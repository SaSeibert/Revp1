package main.java.br.edu.ifrs.bandas.dao;
import java.util.List;

import br.edu.ifrs.bandas.dominio.Album;
import br.edu.ifrs.bandas.dominio.Banda;

public interface AlbumDAO {

    void salvar(Album Album);
    Album buscarPorId(Long id);
    List<Album> listarTodos();
    void atualizar(Album Album);
    void remover(Long id);
    List<Album> listarPorBanda(Banda banda);
}
