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

    @OneToOne
    private FuneralParlor funeralParlor;


    @OneToOne
    private Client client;

    @OneToOne
    private Coffin coffin;

    private String chemicalConservation;

    private String descriptionDeath;
}
