package mg.itu.vokye.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmploye;
    @ManyToOne
    @JoinColumn(name = "id_type_employe")
    private TypeEmploye typeEmploye;
    private String nom;
    private String prenom;
    private String motDePasse;
    private Date dateEntree;
    private Date dateFin;
}
