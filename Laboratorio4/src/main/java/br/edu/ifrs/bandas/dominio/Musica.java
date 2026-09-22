package br.edu.ifrs.bandas.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double duracao;

    @ManyToOne
    private Album album;

    public Musica(){}

    public Musica(String nome, double duracao){
        this.nome = nome;
        this.duracao = duracao;
    }

    public void setAlbum(Album album) { this.album = album; }

    @Override
    public String toString() {
        return nome;
    }
}

