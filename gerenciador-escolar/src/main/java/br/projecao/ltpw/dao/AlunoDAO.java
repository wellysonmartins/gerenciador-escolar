/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projecao.ltpw.dao;

import javax.faces.context.FacesContext;

import br.projecao.ltpw.model.Aluno;
import br.projecao.ltpw.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author alberto torres
 */
public class AlunoDAO {
    
    private static AlunoDAO instancia;
    private AlunoDAO(){
    
    }
    
    public static synchronized AlunoDAO getInstance(){
        if (instancia == null) instancia = new AlunoDAO();
        return instancia;
    }
    
    
    
    private static Transaction transObj;
    private static Session sessionObj;
    
    /**
     * Adiciona um novo aluno na base de dados
     **/
     
    public Aluno salvaAluno(Aluno alunoObj) {        
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            transObj = sessionObj.beginTransaction();
            
            //sessionObj.save(alunoObj);
            sessionObj.saveOrUpdate(alunoObj);
            
            System.out.println("Aluno salvo com Id: " + alunoObj.getIdAluno());
 
        } catch (Exception exceptionObj) {
            exceptionObj.printStackTrace();
        } finally {
            transObj.commit();
            sessionObj.close();
            
        }
        
        return alunoObj;
    }
    
    public Aluno obterAlunoPorChave(Aluno pAluno){
        Aluno lAluno = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
          try {
                Query query = sessionObj.createQuery ("from Aluno where idAluno = " + pAluno.getIdAluno());
                lAluno = (Aluno)query.uniqueResult();
                 System.out.print("==================ID PESSOA===============================");
                System.out.print(lAluno.getPessoa().getIdPessoa());
                
               
            } catch (Exception e) {
                e.printStackTrace();
            }
            
          sessionObj.close();
              return lAluno;
        }
    
      public List<Aluno> obterTodosOsAlunos(){
          sessionObj = HibernateUtil.getSessionFactory().openSession();
          List<Aluno> lAlunos = null;
          try {
                Query query = sessionObj.createQuery ("from Aluno");
                lAlunos = query.list();
                
               
            } catch (Exception e) {
                e.printStackTrace();
            }
              sessionObj.close();
              return lAlunos;
        }
      
      
       public boolean removerAluno(Aluno alunoObj){
          try {
              
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            transObj = sessionObj.beginTransaction();
            sessionObj.delete(alunoObj.getPessoa());
      
            
  
        } catch (Exception exceptionObj) {
            exceptionObj.printStackTrace();
            return false;
        } finally {
            
            transObj.commit();
            sessionObj.close();
            
        }
         return true; 
       }
    
    
    
}
