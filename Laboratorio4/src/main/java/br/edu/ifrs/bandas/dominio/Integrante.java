package br.edu.ifrs.bandas.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Integrante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Funcao funcao;
    private int idade;

    @ManyToOne
    private Banda banda;

    public Integrante(){}

    public Integrante(String nome, int idade, Funcao funcao){
        
        this.nome = nome;
        this.idade = idade;
        this.funcao = funcao;

    }

    public Long getId()         {return id;}
    public String getNome()     {return nome;}
    public Funcao getFuncao()   {return funcao;}
    public int getIdade()       {return idade;}
    public Banda getBanda()     {return banda;}

    public void setBanda(Banda banda) {this.banda = banda;}
    public void setNome (String nome) {this.nome = nome;}

    @Override
    public String toString() {
        return nome + " (" + funcao + ")";
    }
    

}
