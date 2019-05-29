/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projecao.ltpw.view;

import br.projecao.ltpw.model.Turma;
import br.projecao.ltpw.model.Professor;
import br.projecao.ltpw.presenter.TurmaSvl;
import br.projecao.ltpw.presenter.ProfessorSvl;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author alberto.torres
 */
public class TurmaBean implements Serializable{
    
    public TurmaBean(){
        //disciplina = DisciplinaSvl.obterTodasDisciplinas();
    
    }
    
    
    //private List<Disciplina> disciplina;
    private List<Turma> turma;

    //public List<Disciplina> getDisciplina() {
    //    return disciplina;
    //}

    //public void setDisciplina(List<Disciplina> disciplina) {
    //    this.disciplina = disciplina;
    //}

    /**
     * @return the disciplina
     */
    public List<Turma> getTurma() {
        return TurmaSvl.obterTurmas();
    }

    /**
     * @param turma the turma to set
     */
    public void setTurma(List<Turma> turma) {
        this.turma = turma;
    }
    
    

    
    
}
