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
    @Column(name = "nbre_vente")
    private int numVente;
    @Column(name = "chiffre_affaire")
    private Double chiffreAffaires;
    @Column(name = "statut")
    private Boolean statut;
    @Column(name = "photo")
    private String photo;
}
