package mg.itu.vokye.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "employee")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee")
    private Long idEmployee;

    @ManyToOne
    @JoinColumn(name = "id_type_emp")
    private TypeEmploye typeEmploye;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "date_de_naissance")
    private Timestamp dateDeNaissance;

    @Column(name = "num_tel")
    private Long numTel;

    @Column(name = "poste")
    private String poste;

    @Column(name = "nbre_vente")
    private int numVente;

    @Column(name = "chiffre_affaire")
    private Double chiffreAffaires;

    @Column(name = "statut")
    private Boolean statut;

    @Column(name = "date_entrer")
    private Timestamp dateEntrer;

    @Column(name = "date_fin")
    private Timestamp dateFin;
}
