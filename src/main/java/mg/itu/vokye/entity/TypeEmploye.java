package mg.itu.vokye.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class TypeEmploye {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeEmploye;
    private String designation;
    @Column(name = "cota")
    private Double cota;
    private BigDecimal salaireBase;
    private Integer pourcentage;
    @Column(name = "nbre_vente")
    private int nbreVente;
    @Column(name = "chiffre_affaire")
    private Double chiffreAffaire;

}
