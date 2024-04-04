package funerary.genro.feliz.cadastroCliente.repository;

import funerary.genro.feliz.cadastroCliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
