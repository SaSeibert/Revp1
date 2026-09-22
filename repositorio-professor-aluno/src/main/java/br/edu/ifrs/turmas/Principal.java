package br.edu.ifrs.turmas;

import java.util.List;

import br.edu.ifrs.turmas.dao.*;
import br.edu.ifrs.turmas.dao.*;
import br.edu.ifrs.turmas.dominio.Aluno;
import br.edu.ifrs.turmas.dominio.Professor;
import br.edu.ifrs.turmas.dominio.Turma;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Principal {

    public static void main(String[] args) {;
    

//        Professor ana = new Professor("Ana", "ana@ifrs.edu.br");
//
//        Turma turmaA = new Turma("Programacao para Web I - Turma A");
//        Turma turmaB = new Turma("Programacao para Web I - Turma B");
//
//        ana.adicionarTurma(turmaA);
//        ana.adicionarTurma(turmaB);
//
//        turmaA.adicionarAluno(new Aluno("Bruno", "2026001"));
//        turmaA.adicionarAluno(new Aluno("Carla", "2026002"));
//        turmaB.adicionarAluno(new Aluno("Diego", "2026003"));
//
//        System.out.println("Professora: " + ana);
//        System.out.println("Turmas: " + ana.getTurmas());
//        System.out.println();
//
//        for (Turma turma : ana.getTurmas()) {
//            System.out.println(turma + " | alunos: " + turma.getAlunos());
//        }
//        
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("turmas-pu");
//        EntityManager em = emf.createEntityManager();
//        
//        em.getTransaction().begin();
//        em.persist(ana);
//        em.persist(turmaA);
//        em.persist(turmaB);
//        
//        for(Aluno a: turmaA.getAlunos()) {
//        	em.persist(a);
//        }
//        
//        for(Aluno b: turmaB.getAlunos()) {
//        	em.persist(b);
//        }
//        
//        em.getTransaction().commit();
//        
//        em.close();
//        emf.close();
        
        // A pergunta de hoje: quando este programa termina, o que sobra
        // da professora Ana e das turmas dela? 
    	
//    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("turmas-pu");
//    	EntityManager em = emf.createEntityManager();
//    	
//    	Professor professor = em.find(Professor.class, 1L); //L refere-se a Long
//    	System.out.println(professor);
//    	
//    	professor.setEmail("anuxa@hotmail.com");
//
//    	em.getTransaction().begin();
//    	em.merge(professor);
//    	em.getTransaction().commit();
//    	
//    	Aluno aluno = em.find(Aluno.class, 1L);
//    	
//    	aluno.setNome("Vitor Hugo");
//    	em.getTransaction().begin();
//    	em.merge(aluno);
//    	em.getTransaction().commit();
//    	
////    	Professor alex = em.find(Professor.class, 2L);
////    	
////    	em.getTransaction().begin();
////    	em.remove(alex);
////    	em.getTransaction().commit();
//    	
//    	List<Aluno> alunos = em.
//    							createQuery("SELECT a FROM Aluno a", Aluno.class)
//    							.getResultList();
//    	
//    	
//    	System.out.println(alunos);
//    	
//    	Turma turma = em.find(Turma.class, 1L);
//    	
////    	System.out.println(turma.getAlunos());
//    	
//    	List<Aluno> alunos_a = em
//    			.createQuery("SELECT a FROM Aluno a WHERE a.turma = :turma", Aluno.class)
//    			.setParameter("turma", turma)
//    			.getResultList();
//    	
//    	System.out.println(alunos_a);
//    	
//    	em.close();
//    	emf.close();
    
    
		ProfessorDAO professorDAO = new ProfessorDAOJPA();   
	    
	    Professor ana = new Professor("Ana", "ana@ifrs.edu.br");
	    professorDAO.salvar(ana);
	    ana.setEmail("anuxa@email.com");
	    professorDAO.atualizar(ana);
	    
	    Professor vitor = new Professor("Vitor", "vitor@ifrs.edu.br");
	    professorDAO.salvar(vitor);
	    
	    professorDAO.remover(1L);
    
    	
    }
}
