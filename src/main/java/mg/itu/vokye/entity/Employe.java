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
  
    @Column(name = "date_de_naissance")
  
    private Date dateDeNaissance;
    @Column(name = "num_tel")
    private int numTel;
  
    @ManyToOne
    @JoinColumn(name = "id_genre")
    private Genres genre;

    @Column(name = "date_entree")
    private Timestamp dateEntree;

    @Column(name = "date_fin")
    private Timestamp dateFin;

    @Column(name = "mot_de_passe")
    private String motDePasse;

    @Column(name = "email")
    private String email;

    @Column(name = "photo")
    private String photo;

}
