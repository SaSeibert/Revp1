package br.edu.ifrs.bandas.dao;

import java.util.List;

import br.edu.ifrs.bandas.dominio.Banda;

public interface BandaDAO {

    void salvar(Banda banda);
    Banda buscarPorId(Long id);
    List<Banda> listarTodos();
    void atualizar(Banda banda);
    void remover(Long id);
    List<Banda> listarPorGenero(String genero);
}
