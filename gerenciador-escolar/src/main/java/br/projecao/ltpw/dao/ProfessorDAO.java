/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projecao.ltpw.dao;

import javax.faces.context.FacesContext;

import br.projecao.ltpw.model.Professor;
import br.projecao.ltpw.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author alberto torres
 */
public class ProfessorDAO {
    
    private static ProfessorDAO instancia;
    private ProfessorDAO(){
    
    }
    
    public static synchronized ProfessorDAO getInstance(){
        if (instancia == null) instancia = new ProfessorDAO();
        return instancia;
    }
    
    
    
    private static Transaction transObj;
    private static Session sessionObj;
    
    /**
     * Adiciona um novo aluno na base de dados
     **/
     
    public Professor salvaProfessor(Professor professorObj) {        
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            transObj = sessionObj.beginTransaction();
            
            //sessionObj.save(alunoObj);
            sessionObj.saveOrUpdate(professorObj);
            
            System.out.println("Professor salvo com Id: " + professorObj.getIdProfessor());
 
        } catch (Exception exceptionObj) {
            exceptionObj.printStackTrace();
        } finally {
            transObj.commit();
            sessionObj.close();
            
        }
        
        return professorObj;
    }
    
    public Professor obterProfessorPorChave(Professor pProfessor){
        Professor lProfessor = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
          try {
                Query query = sessionObj.createQuery ("from Professor where idProfessor = " + pProfessor.getIdProfessor());
                lProfessor = (Professor)query.uniqueResult();
                 System.out.print("==================ID PESSOA===============================");
                System.out.print(lProfessor.getPessoa().getIdPessoa());
                
               
            } catch (Exception e) {
                e.printStackTrace();
            }
            
          sessionObj.close();
              return lProfessor;
        }
    
      public List<Professor> obterTodosOsProfessores(){
          sessionObj = HibernateUtil.getSessionFactory().openSession();
          List<Professor> lProfessores = null;
          try {
                Query query = sessionObj.createQuery ("from professor");
                lProfessores = query.list();
                
               
            } catch (Exception e) {
                e.printStackTrace();
            }
              sessionObj.close();
              return lProfessores;
        }
      
      
       public boolean removerProfessor(Professor professorObj){
          try {
              
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            transObj = sessionObj.beginTransaction();
            sessionObj.delete(professorObj.getPessoa());
      
            
  
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
