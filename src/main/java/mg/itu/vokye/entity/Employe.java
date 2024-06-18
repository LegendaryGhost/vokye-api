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
    private int idEmployee;

    @ManyToOne
    @JoinColumn(name = "id_type_emp")
    private TypeEmploye typeEmploye;

    @Column(name = "Nom")
    private String nom;

    @Column(name = "Prenom")
    private String prenom;

    @Column(name = "Date_de_naissance")
    private Timestamp dateDeNaissance;

    @Column(name = "Num_tel")
    private int numTel;

    @Column(name = "Poste")
    private String poste;

    @Column(name = "Nbre_vente")
    private int numVente;

    @Column(name = "Chiffre_affaire")
    private Double chiffreAffaires;

    @Column(name = "Statut")
    private Boolean statut;

    @Column(name = "Date_entrer")
    private Timestamp dateEntrer;

    @Column(name = "Date_fin")
    private Timestamp dateFin;
}
