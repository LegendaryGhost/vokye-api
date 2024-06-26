package mg.itu.vokye.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "type_depense")
public class TypeDepense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_type_depense;

    private String designation;

    // Getters and Setters
}
