package br.edu.ifrs.bandas.dominio;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity 
public class Banda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @OneToMany(mappedBy = "banda")
    private List<Integrante> integrantes = new ArrayList<>();

    @OneToMany(mappedBy = "banda")
    private List<Album> albuns = new ArrayList<>();


    public Long getId()                        {return id;}
    public String getNome()                    {return nome;}
    public Genero getGenero()                  {return genero;}
    public List<Integrante> getIntegrantes()   {return integrantes;}
    public List<Album> getAlbuns()             {return albuns;}

    public Banda(){}
    public Banda(String nome, Genero genero){
        this.nome = nome;
        this.genero = genero;
    }

    public void setNome(String nome) {this.nome = nome;}

    public void adicionarAlbum(Album album) {
        albuns.add(album);
        album.setBanda(this);
    }

    public void adicionarIntegrante(Integrante integrante) {
        integrantes.add(integrante);
        integrante.setBanda(this);
    }

    @Override
    public String toString() {
        return nome;
    }
}

