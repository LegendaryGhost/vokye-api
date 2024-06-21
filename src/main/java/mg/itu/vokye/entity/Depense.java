package mg.itu.vokye.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Depense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_depense;

    @ManyToOne()
    @JoinColumn(name = "id_type_depense", nullable = false)
    private TypeDepense typeDepense;

    double prix;

    LocalDate date_depense;


}