/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projecao.ltpw.view;

import br.projecao.ltpw.model.Aluno;
import br.projecao.ltpw.model.Genero;
import br.projecao.ltpw.model.Professor;
import br.projecao.ltpw.presenter.AlunoSvl;
import br.projecao.ltpw.presenter.GeneroSvl;
import br.projecao.ltpw.presenter.ProfessorSvl;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author alberto.torres
 */
public class ProfessorBean implements Serializable{
    
    public ProfessorBean(){
        genero = GeneroSvl.obterTodosGeneros();
    
    }
    
    
    private List<Genero> genero;
    private List<Professor> professor;

    public List<Genero> getGenero() {
        return genero;
    }

    public void setGenero(List<Genero> genero) {
        this.genero = genero;
    }

    /**
     * @return the professor
     */
    public List<Professor> getProfessor() {
        return ProfessorSvl.obterProfessores();
    }

    /**
     * @param professor the professor to set
     */
    public void setProfessor(List<Professor> professor) {
        this.professor = professor;
    }
    
    

    
    
}
