package mg.itu.vokye.entity;

import jakarta.persistence.*;
import lombok.Data;

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

    @ManyToOne
    @JoinColumn(name = "id_genre")
    private Genre genre;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

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
