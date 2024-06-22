package mg.itu.vokye.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Utilitaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilitaire;
    private String nom;
    @ManyToOne
    @JoinColumn(name = "id_unite")
    private Unite unite;
    private Double stock;
}
