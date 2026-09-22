package br.edu.ifrs.turmas.dao;

import java.util.List;

import br.edu.ifrs.turmas.dominio.Professor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProfessorDAOJPA implements ProfessorDAO {
	
	private EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("turmas-pu");
	
	public void salvar(Professor professor) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(professor);
		em.getTransaction().commit();
		em.close();
	}
	
	public Professor buscarPorId(Long id) {
		EntityManager em = emf.createEntityManager();
		Professor professor = em.find(Professor.class, id);
		em.close();
		
		return professor;
	}
	
	public void atualizar(Professor professor) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(professor);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Professor> listarTodos() {
		EntityManager em = emf.createEntityManager();
		
		List<Professor> professores = em
				.createQuery("SELECT p FROM Professor p",Professor.class)
				.getResultList();
		em.close();
		
		return professores;
	}
	
	public void remover(Long id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Professor professor = em.find(Professor.class, id);
		em.remove(professor);
		em.getTransaction().commit();
		em.close();
	}
	
	
}
