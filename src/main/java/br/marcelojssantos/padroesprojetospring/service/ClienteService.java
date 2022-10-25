package br.marcelojssantos.padroesprojetospring.service;

import br.marcelojssantos.padroesprojetospring.model.Cliente;
import org.springframework.stereotype.Service;

public interface ClienteService {
    Iterable<Cliente> buscarTodos();
    Cliente buscarPorId(Long id);
    void inserir(Cliente cliente);
    void atualizar(Long id, Cliente cliente);
    void deletar(Long id);
}
