package funerary.genro.feliz.cadastroCliente.service;

import funerary.genro.feliz.cadastroCliente.dto.ClienteDTO;
import funerary.genro.feliz.cadastroCliente.form.ClienteForm;
import funerary.genro.feliz.cadastroCliente.model.Cliente;
import funerary.genro.feliz.cadastroCliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public HttpStatus cadastrarCliente(ClienteForm clienteForm) {

        Cliente cliente = new Cliente();
        cliente.setNome(clienteForm.getNome());
        cliente.setDataNascimento(clienteForm.getDataNascimento());
        cliente.setCidadeNascimento(clienteForm.getCidadeNascimento());
        cliente.setRg(clienteForm.getRg());
        cliente.setCpf(clienteForm.getCpf());
        cliente.setProfissao(clienteForm.getProfissao());
        cliente.setReligiao(clienteForm.getReligiao());
        cliente.setEstado_civil(clienteForm.getEstado_civil());
        cliente.setTelefone(clienteForm.getTelefone());
        clienteRepository.save(cliente);
        return HttpStatus.CREATED;
    }

    public List<ClienteDTO> listarClientes() {
        List<Cliente> clientes = this.clienteRepository.findAll();
        return ClienteDTO.converter(clientes);

    }
}
