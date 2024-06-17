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
    private Long idTypeEmp;

    @Column(name = "designation")
    private String designation;

    @Column(name = "salaire_base")
    private BigDecimal salaireBase;

    @Column(name = "nbre_vente")
    private Integer nbreVente;

    @Column(name = "chiffre_affaire")
    private BigDecimal chiffreAffaire;

    @Column(name = "pourcentage")
    private Integer pourcentage;
}
