package br.edu.ifrs.turmas.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String matricula;
    
    @ManyToOne
    private Turma turma;
    
    public Aluno() {
    }

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    public Long getId()           { return id; }
    public String getNome()       { return nome; }
    public String getMatricula()  { return matricula; }
    public Turma getTurma()       { return turma; }

    public void setTurma(Turma turma) { this.turma = turma; }
    
    public void setNome(String nome) {
    	this.nome = nome;
    }
    
    @Override
    public String toString() {
        return nome + " (" + matricula + ")";
    }
}
