package funerary.genro.feliz.cadastroCliente.dto;

import funerary.genro.feliz.cadastroCliente.model.Cliente;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record ClienteDTO(Long id, String nome, LocalDate dataNascimento,
                         String cidadeNascimento, String rg, String cpf, String profissao, String religiao, String estadoCivil, Long telefone) {

    public static ClienteDTO fromCliente(Cliente cliente){
        return new ClienteDTO(cliente.getId(), cliente.getNome(),
                cliente.getDataNascimento(), cliente.getCidadeNascimento(), cliente.getRg(), cliente.getCpf(), cliente.getProfissao(),
                cliente.getReligiao(), cliente.getEstado_civil(), cliente.getTelefone());
    }

    public static List<ClienteDTO> converter(List<Cliente> clientes){
        return clientes.stream().map(ClienteDTO::fromCliente).collect(Collectors.toList());
    }
}

