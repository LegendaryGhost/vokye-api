package mg.itu.vokye.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

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
  
}
