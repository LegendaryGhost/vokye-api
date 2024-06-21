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
    private String prenom;
    private String email;

    private Date dateDeNaissance;

    @Column(name = "num_tel")
    private int numTel;

    @Column(name = "designation")
    private String designation;

    @Column(name = "date_entree")
    private Date dateEntree;

    @Column(name = "date_fin")
    private Date dateFin;

    @Column(name = "mot_de_passe")
    private String motDePasse;

    @Column(name = "photo")
    private String photo;
    private Date dateNaissance;
}
