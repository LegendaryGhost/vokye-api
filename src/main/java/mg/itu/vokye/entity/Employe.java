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

    @ManyToOne
    @JoinColumn(name = "id_genre")
    private Genre genre;

    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "email")
    private String email;
    @Column(name = "date_naissance")
    private Date date_naissance ;

    @Column(name = "num_tel")
    private int numTel;

    @Column(name = "date_entree")
    private Date dateEntree;

    @Column(name = "date_fin")
    private Date dateFin;

    @Column(name = "mot_de_passe")
    private String motDePasse;

    @Column(name = "photo")
    private String photo;
}
