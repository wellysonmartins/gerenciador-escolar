/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.projecao.ltpw.view;

import br.projecao.ltpw.model.Aluno;
import br.projecao.ltpw.model.Genero;
import br.projecao.ltpw.presenter.AlunoSvl;
import br.projecao.ltpw.presenter.GeneroSvl;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author alberto.torres
 */
public class AlunoBean implements Serializable{
    
    public AlunoBean(){
        genero = GeneroSvl.obterTodosGeneros();
    
    }
    
    
    private List<Genero> genero;
    private List<Aluno> aluno;

    public List<Genero> getGenero() {
        return genero;
    }

    public void setGenero(List<Genero> genero) {
        this.genero = genero;
    }

    /**
     * @return the aluno
     */
    public List<Aluno> getAluno() {
        return AlunoSvl.obterAlunos();
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(List<Aluno> aluno) {
        this.aluno = aluno;
    }
    
    

    
    
}
