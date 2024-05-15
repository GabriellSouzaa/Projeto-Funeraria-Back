package funerary.genro.feliz.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "funeral_plan")
@Getter
@Setter
public class FuneralPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataEnvio;

    private Float valor;

    private String pagoEsseMes;

    private LocalDate dataPagamento;

    private LocalDate dataPagamentoEfetuado;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;
}
