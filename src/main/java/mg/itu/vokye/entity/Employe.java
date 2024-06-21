package mg.itu.vokye.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;


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
    private Timestamp dateEntree;
    private Timestamp dateFin;
    @ManyToOne
    @JoinColumn(name = "id_genre")
    private Genres genre;
    private String email;
    private String photo;
    private Date dateNaissance;
    private int numTel;

}
