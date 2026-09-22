package br.edu.ifrs.turmas.dao;

import java.util.List;

import br.edu.ifrs.turmas.dominio.Professor;

public interface ProfessorDAO {
	void salvar(Professor professor);
	Professor buscarPorId(Long id);
	List<Professor> listarTodos();
	void atualizar(Professor professor);
	void remover(Long id);
}
