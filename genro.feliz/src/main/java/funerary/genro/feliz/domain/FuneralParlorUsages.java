package funerary.genro.feliz.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "funeral_parlor_usages")
@Getter
@Setter
public class FuneralParlorUsages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private FuneralParlor funeralParlor;

    private String uso;

    private LocalDate dataUso;
}
