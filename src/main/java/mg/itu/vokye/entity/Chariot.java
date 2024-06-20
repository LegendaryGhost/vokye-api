package mg.itu.vokye.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "chariot")
public class Chariot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_chariot;

    @ManyToOne
    @JoinColumn(name = "id_employe")
    private Employe employe;

    // Getters and Setters
}
