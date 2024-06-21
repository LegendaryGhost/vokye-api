package mg.itu.vokye.entity;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class EtatUtilitaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtatUtilitaire;
    @ManyToOne
    @JoinColumn(name = "id_utilitaire")
    private Utilitaire utilitaire;
    @ManyToOne
    @JoinColumn(name = "id_etat")
    private Etat etat;
    private Date dateEtatUtilitaire;

}
