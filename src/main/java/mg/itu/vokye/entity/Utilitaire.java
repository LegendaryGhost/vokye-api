package mg.itu.vokye.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Utilitaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilitaire;
    @ManyToOne
    @JoinColumn(name = "id_utilitaire")
    private String nom;
    private Unite unite;
}
