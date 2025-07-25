package funerary.genro.feliz.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "patient_death")
@Getter
@Setter
public class PatientDeath {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private FuneralParlor funeralParlor;


    @OneToOne
    private Client client;

    @ManyToOne
    private Coffin coffin;

    private String chemicalConservation;

    private String descriptionDeath;
}
