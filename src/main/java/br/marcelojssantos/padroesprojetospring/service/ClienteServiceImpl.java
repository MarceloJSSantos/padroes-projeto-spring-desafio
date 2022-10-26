package br.marcelojssantos.padroesprojetospring.service;

import br.marcelojssantos.padroesprojetospring.model.Cliente;
import br.marcelojssantos.padroesprojetospring.model.ClienteRepository;
import br.marcelojssantos.padroesprojetospring.model.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        var cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        var clienteBD = clienteRepository.findById(id);
        if(clienteBD.isPresent()){
            cliente.setId(id);
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente) {
        var cepCliente = cliente.getEndereco().getCep();
        var endereco = enderecoRepository.findById(cepCliente).orElseGet(() ->{
            var novoEndereco = viaCepService.consultarCep(cepCliente);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
