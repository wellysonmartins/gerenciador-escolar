/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projecao.ltpw.presenter;

import br.projecao.ltpw.dao.TurmaDAO;
import br.projecao.ltpw.dao.GeneroDAO;
import br.projecao.ltpw.model.Turma;
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
public class TurmaSvl extends HttpServlet {

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
            out.println("<title>Servlet TurmaSvl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TurmaSvl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    
    
    public static List<Turma> obterTurmas() {
        List<Turma> lTurmas;
        lTurmas = TurmaDAO.getInstance().obterTodasAsTurmas();
        
        return lTurmas;
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
        Turma pTurma = new Turma();
        pTurma.setIdTurma(Integer.parseInt(id));
        pTurma = TurmaDAO.getInstance().obterTurmaPorChave(pTurma);
        
        //Se op=1 então alterar
        if (op.equals("1")){
  
            request.setAttribute("turma", pTurma);
            request.getRequestDispatcher("turma_form.jsp").forward(request, response);
            
         //Se op=2 então excluir
         }else if (op.equals("2")){
            
             boolean result = TurmaDAO.getInstance().removerTurma(pTurma);
            
             //Se foi excluido com sucesso result = true
             if (result){
                 request.setAttribute("msg", "Excluido com sucesso!");
                 request.getRequestDispatcher("turma_lista.jsp").forward(request, response);  
             }else{
             //houve erro na exclusao entao result = false
                 request.setAttribute("msg_erro", "Erro na Exclusao!");
                 request.getRequestDispatcher("turma_lista.jsp").forward(request, response);  
             
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
        Turma pTurma = new Turma();
        
       
                
        //verifica se é uma atualização ou nova inserção
        //atualizacao é enviado parâmetro com o id do aluno
        if(request.getParameter("id_turma")!= null && !request.getParameter("id_turma").equals("")){
            pTurma.setIdTurma(Integer.parseInt(request.getParameter("id_turma")));
            pTurma = TurmaDAO.getInstance().obterTurmaPorChave(pTurma);
            request.setAttribute("msg", pTurma.getNome() + " atualizado com sucesso!");
            param_msg = " atualizado com sucesso!";
     
        }else{
             param_msg = " inserido com sucesso!";
        }
        
        if (pTurma.getProfessor() == null) pTurma.setProfessor(new Professor());
        
        
        
        
        
        pTurma = TurmaDAO.getInstance().salvaTurma(pTurma);
        
        request.setAttribute("msg", pTurma.getProfessor() + param_msg);
     
        request.getRequestDispatcher("turma_form.jsp").forward(request, response);  
        
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
