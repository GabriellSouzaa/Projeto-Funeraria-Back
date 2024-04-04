package funerary.genro.feliz.cadastroCliente.controller;

import funerary.genro.feliz.cadastroCliente.dto.ClienteDTO;
import funerary.genro.feliz.cadastroCliente.form.ClienteForm;
import funerary.genro.feliz.cadastroCliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(path = "/listar")
    public ResponseEntity<List<ClienteDTO>> listarClientes(){
        return  ResponseEntity.ok(this.clienteService.listarClientes());
    }

    @PostMapping(path = "/cadastrar")
    public ResponseEntity<Void> cadastrarCliente(@RequestBody ClienteForm clienteForm){
        return ResponseEntity.status(this.clienteService.cadastrarCliente(clienteForm)).build();
    }

}
