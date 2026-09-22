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
    
    @ManyToOne //Lado dono - leva a coluna de chave estrangeira para a relacao professor - turma
    private Professor professor;
    
    @OneToMany(mappedBy = "turma") //Lado espelho em relacao a turma -aluno
    private List<Aluno> alunos = new ArrayList<>();
    //Lado espelho leva mappedby apontando o nome do atributo do lado do dono

    //Turma.professor    @ManyToOne                         lado DONO
    //Professor.turmas   @OneToMany(mappedby = "professor") lado ESPELHO
    //Aluno.turma        @ManyToOne                         lado DONO
    //Turma.alunos       @OneToMany(mappedby = "turma")     lado ESPELHO

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
