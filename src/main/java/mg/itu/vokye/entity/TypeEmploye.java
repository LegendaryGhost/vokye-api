package mg.itu.vokye.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "type_emp")
public class TypeEmploye {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_emp")
    private int idTypeEmp;

    @Column(name = "designation")
    private String designation;

    @Column(name = "salaire_base")
    private Double salaireBase;

    @Column(name = "nbre_vente")
    private int nbreVente;

    @Column(name = "chiffre_affaire")
    private Double chiffreAffaire;

    @Column(name = "pourcentage")
    private int pourcentage;
}
