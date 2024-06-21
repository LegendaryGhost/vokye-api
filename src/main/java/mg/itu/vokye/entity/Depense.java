package mg.itu.vokye.entity;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Depense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDepense;
    @ManyToOne
    @JoinColumn(name = "id_type_depense")
    private TypeDepense typeDepense;
    private Double prix;
    private Date dateDepense;
}
