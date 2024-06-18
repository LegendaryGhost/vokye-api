package mg.itu.vokye.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

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
    private BigDecimal salaireBase;

    @Column(name = "Nbre_vente")
    private int nbreVente;

    @Column(name = "Chiffre_affaire")
    private BigDecimal chiffreAffaire;

    @Column(name = "Pourcentage")
    private Integer pourcentage;
}
