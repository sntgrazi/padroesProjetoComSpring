package padroes.spring.padroes.service.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import padroes.spring.padroes.model.Cliente;
import padroes.spring.padroes.model.ClienteRepository;
import padroes.spring.padroes.model.Endereco;
import padroes.spring.padroes.model.EnderecoRepository;
import padroes.spring.padroes.service.ClienteService;
import padroes.spring.padroes.service.ViaCepService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienterepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCep;

    @Override
    public void atualizar(Long id, Cliente cliente) {
         Optional<Cliente> clienteBd = clienterepository.findById(id);
        if(clienteBd.isPresent()){
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public Cliente buscarPorId(long id) {
        Optional<Cliente> cliente = clienterepository.findById(id);
        return cliente.get();
    }

    @Override
    public void deletar(Long id) {
        clienterepository.deleteById(id);
        
    }

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienterepository.findAll();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    private void salvarClienteComCep(Cliente cliente){
        String cep = cliente.getEndereco().getCep();
        Endereco novoEndereco = viaCep.consultarCep(cep);
        enderecoRepository.save(novoEndereco);
        
        cliente.setEndereco(novoEndereco);

        clienterepository.save(cliente);
    }
}
