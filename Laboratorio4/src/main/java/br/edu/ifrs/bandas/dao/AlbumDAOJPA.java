package main.java.br.edu.ifrs.bandas.dao;

import br.edu.ifrs.bandas.dominio.Album;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AlbumDAOJPA implements AlbumDAO{

private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bandas-pu");

    public void salvar(Album album){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(album);
        em.getTransaction().commit();
        em.close();
    }

    public Album buscarPorId (Long id){
        EntityManager em = emf.createEntityManager();
        ALbum album = em.find(Album.class,id);
        em.close();
        return album;
    }

    public List<Album> listarTodos(){
        EntityManager em = emf.createEntityManager();
        List<Album> albuns = em.createQuery("SELCT a FROM Album a",Album.class).getResultList();
        em.close();
        return albuns;
    }

    public void atualizar(Album album){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(album);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Long id){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Album album = em.find(Album.class,id);
        em.remove(album);
        em.getTransaction().commit();
        em.close();
    }

    public List<Album> listarPorBanda(Banda banda){
        EntityManager em = emf.createEntityManager();
        List<Album> albuns = em
        .createQuery("SELECT a FROM Album a WHERE a.banda =: banda",Album.class)
        .setParameter("banda",banda)
        .getResultList();
    }

}
