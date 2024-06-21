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
    private String email;
    private String motDePasse;
    private Date dateEntree;
    private Date dateFin;
  
    @Column(name = "date_de_naissance")
    private Timestamp dateDeNaissance;
  
    @Column(name = "num_tel")
    private int numTel;
  
    @Column(name = "designation")
    private String designation;

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

