package mg.itu.vokye.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "depense")
public class Depense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_depense;

    @ManyToOne
    @JoinColumn(name = "id_type_depense")
    private TypeDepense typeDepense;

    private BigDecimal prix;
    private Date date_depense;

    // Getters and Setters
}
