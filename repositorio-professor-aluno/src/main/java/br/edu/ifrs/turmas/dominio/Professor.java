package br.edu.ifrs.turmas.dominio;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    
    @OneToMany(mappedBy = "professor")
    private List<Turma> turmas = new ArrayList<>();

    public Professor() {
    }

    public Professor(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public void adicionarTurma(Turma turma) {
        turmas.add(turma);
        turma.setProfessor(this);
    }

    public Long getId()            { return id; }
    public String getNome()        { return nome; }
    public String getEmail()       { return email; }
    public List<Turma> getTurmas() { return turmas; }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public void setNome(String nome) {
    	this.nome = nome;
    }
    
    @Override
    public String toString() {
        return nome;
    }
}
