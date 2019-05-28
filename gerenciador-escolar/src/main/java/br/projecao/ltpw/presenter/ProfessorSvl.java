/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projecao.ltpw.presenter;

import br.projecao.ltpw.dao.AlunoDAO;
import br.projecao.ltpw.dao.GeneroDAO;
import br.projecao.ltpw.dao.ProfessorDAO;
import br.projecao.ltpw.model.Aluno;
import br.projecao.ltpw.model.Genero;
import br.projecao.ltpw.model.Pessoa;
import br.projecao.ltpw.model.Professor;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alberto.torres
 */
public class ProfessorSvl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProfessorSvl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProfessorSvl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    
    
    public static List<Professor> obterProfessores() {
        List<Professor> lProfessores;
        lProfessores = ProfessorDAO.getInstance().obterTodosOsProfessores();
        
        return lProfessores;
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        String id = request.getParameter("id");
        String op = request.getParameter("op");
        Professor pProfessor = new Professor();
        pProfessor.setIdProfessor(Integer.parseInt(id));
        pProfessor = ProfessorDAO.getInstance().obterProfessorPorChave(pProfessor);
        
        //Se op=1 então alterar
        if (op.equals("1")){
  
            request.setAttribute("professor", pProfessor);
            request.getRequestDispatcher("professor_form.jsp").forward(request, response);
            
         //Se op=2 então excluir
         }else if (op.equals("2")){
            
             boolean result = ProfessorDAO.getInstance().removerProfessor(pProfessor);
            
             //Se foi excluido com sucesso result = true
             if (result){
                 request.setAttribute("msg", "Excluido com sucesso!");
                 request.getRequestDispatcher("professor_lista.jsp").forward(request, response);  
             }else{
             //houve erro na exclusao entao result = false
                 request.setAttribute("msg_erro", "Erro na Exclusao!");
                 request.getRequestDispatcher("professor_lista.jsp").forward(request, response);  
             
             }
             
         }
        
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String param_msg;
        Professor pProfessor = new Professor();
        
       
        //Trata erro no tipo de dados do salário
        try{
            pProfessor.setSalario(Double.parseDouble(request.getParameter("salario")));
        }catch(Exception ex){
            ex.printStackTrace();
            
            request.setAttribute("msg_error", "O campo salario deve possuir um valor numérico");
            request.getRequestDispatcher("professor_form.jsp").forward(request, response); 
        
        }
        
        //verifica se é uma atualização ou nova inserção
        //atualizacao é enviado parâmetro com o id do aluno
        if(request.getParameter("id_professor")!= null && !request.getParameter("id_professor").equals("")){
            pProfessor.setIdProfessor(Integer.parseInt(request.getParameter("id_professor")));
            pProfessor = ProfessorDAO.getInstance().obterProfessorPorChave(pProfessor);
            request.setAttribute("msg", pProfessor.getPessoa().getNome() + " " + pProfessor.getPessoa().getSobrenome() + " atualizado com sucesso!");
            param_msg = " atualizado com sucesso!";
     
        }else{
             param_msg = " inserido com sucesso!";
        }
        
        if (pProfessor.getPessoa() == null) pProfessor.setPessoa(new Pessoa());
        
        pProfessor.getPessoa().setNome(request.getParameter("nome"));
        pProfessor.getPessoa().setSobrenome(request.getParameter("sobrenome"));
        pProfessor.getPessoa().setEmail(request.getParameter("email"));
 
        //tenta carregar o genero
        try {
            Genero lGenero = new Genero();
            lGenero.setIdGenero(Integer.parseInt(request.getParameter("genero")));
            pProfessor.getPessoa().setGenero(GeneroDAO.getInstance().obterGeneroPorChave(lGenero));
            
        }catch(Exception e){
            e.printStackTrace();
        }

        pProfessor.getPessoa().setMatricula(request.getParameter("matricula"));
        pProfessor.getPessoa().setUsuario(request.getParameter("login"));
        
        //Altera a senha apenas se o campo estiver preenchido
        if (request.getParameter("pwd")!= null && !request.getParameter("pwd").equals(""))
            pProfessor.getPessoa().setSenha(request.getParameter("pwd"));
        
        //Controle de exceção para erro na conversão das datas
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            pProfessor.getPessoa().setDataIngresso(sdf.parse(request.getParameter("data_ingresso")));
            pProfessor.getPessoa().setDataNascimento(sdf.parse(request.getParameter("data_nascimento")));
        } catch (ParseException ex) {
            Logger.getLogger(ProfessorSvl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        pProfessor = ProfessorDAO.getInstance().salvaProfessor(pProfessor);
        
        request.setAttribute("msg", pProfessor.getPessoa().getNome() + " " + pProfessor.getPessoa().getSobrenome() + param_msg);
     
        request.getRequestDispatcher("professor_form.jsp").forward(request, response);  
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
