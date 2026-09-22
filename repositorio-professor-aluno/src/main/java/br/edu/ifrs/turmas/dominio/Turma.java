package br.edu.ifrs.turmas.dominio;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    
    @ManyToOne
    private Professor professor;
    
    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos = new ArrayList<>();

    public Turma() {
    }

    public Turma(String nome) {
        this.nome = nome;
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
        aluno.setTurma(this);
    }

    public Long getId()            { return id; }
    public String getNome()        { return nome; }
    public Professor getProfessor() { return professor; }
    public List<Aluno> getAlunos() { return alunos; }

    public void setProfessor(Professor professor) { this.professor = professor; }

    @Override
    public String toString() {
        return nome;
    }
}
