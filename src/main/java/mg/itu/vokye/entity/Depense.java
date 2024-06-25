package mg.itu.vokye.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Depense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_depense;
    @ManyToOne
    @JoinColumn(name = "id_type_depense")
    private TypeDepense typeDepense;
    private Double prix;
    private Date dateDepense;
}
