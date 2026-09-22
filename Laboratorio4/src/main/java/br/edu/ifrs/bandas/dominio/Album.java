package br.edu.ifrs.bandas.dominio;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity 
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    private Banda banda;
    private int anoLancamento;
    @Enumerated(EnumType.STRING)
    private Genero genero;

    @OneToMany(mappedBy = "album")
    private List<Musica> musicas = new ArrayList<>();
    
    public Album(){}

    public Album(String nome, Genero genero, int anoLancamento){
        this.nome = nome;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
        musica.setAlbum(this);
    }

    public void setBanda(Banda banda) {this.banda =banda;}

    public Long getId()              {return id;}
    public String getNome()          {return nome;}
    public Banda getBanda()          {return banda;}
    public int getAnoLancamento()    {return anoLancamento;}
    public Genero getGenero()        {return genero;}
    public List<Musica> getMusicas() {return musicas;}
    
    @Override
    public String toString() {
        return nome;
    }
}
