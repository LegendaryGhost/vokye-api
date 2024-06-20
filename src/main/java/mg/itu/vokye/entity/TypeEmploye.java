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

    @Column(name = "Designation")
    private String designation;

    @Column(name = "Salaire_base")
    private Double salaireBase;

    @Column(name = "Nbre_vente")
    private int nbreVente;

    @Column(name = "Chiffre_Affaire")
    private Double chiffreAffaire;

    @Column(name = "Pourcentage")
    private int pourcentage;
}
