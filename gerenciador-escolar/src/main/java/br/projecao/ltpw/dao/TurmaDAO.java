/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projecao.ltpw.dao;

import javax.faces.context.FacesContext;

import br.projecao.ltpw.model.Turma;
import br.projecao.ltpw.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author alberto torres
 */
public class TurmaDAO {
    
    private static TurmaDAO instancia;
    private TurmaDAO(){
    
    }
    
    public static synchronized TurmaDAO getInstance(){
        if (instancia == null) instancia = new TurmaDAO();
        return instancia;
    }
    
    
    
    private static Transaction transObj;
    private static Session sessionObj;
    
    /**
     * Adiciona um novo aluno na base de dados
     **/
     
    public Turma salvaTurma(Turma turmaObj) {        
        try {
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            transObj = sessionObj.beginTransaction();
            
            //sessionObj.save(alunoObj);
            sessionObj.saveOrUpdate(turmaObj);
            
            System.out.println("Turma salva com Id: " + turmaObj.getIdTurma());
 
        } catch (Exception exceptionObj) {
            exceptionObj.printStackTrace();
        } finally {
            transObj.commit();
            sessionObj.close();
            
        }
        
        return turmaObj;
    }
    
    public Turma obterTurmaPorChave(Turma pTurma){
        Turma lTurma = null;
        sessionObj = HibernateUtil.getSessionFactory().openSession();
          try {
                Query query = sessionObj.createQuery ("from Turma where idTurma = " + pTurma.getIdTurma());
                lTurma = (Turma)query.uniqueResult();                
               
            } catch (Exception e) {
                e.printStackTrace();
            }
            
          sessionObj.close();
              return lTurma;
        }
    
      public List<Turma> obterTodasAsTurmas(){
          sessionObj = HibernateUtil.getSessionFactory().openSession();
          List<Turma> lTurmas = null;
          try {
                Query query = sessionObj.createQuery ("from Turma");
                lTurmas = query.list();
                
               
            } catch (Exception e) {
                e.printStackTrace();
            }
              sessionObj.close();
              return lTurmas;
        }
      
      
       public boolean removerTurma(Turma turmaObj){
          try {
              
            sessionObj = HibernateUtil.getSessionFactory().openSession();
            transObj = sessionObj.beginTransaction();
            
      
            
  
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
