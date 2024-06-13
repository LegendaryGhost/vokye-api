package mg.itu.vokye.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class TypeEmploye {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTypeEmploye;
    private String designation;
    private BigDecimal salaireBase;
    private Integer pourcentage;

    // getters and setters
    public Long getIdTypeEmploye() {
        return idTypeEmploye;
    }

    public void setIdTypeEmploye(Long idTypeEmploye) {
        this.idTypeEmploye = idTypeEmploye;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public BigDecimal getSalaireBase() {
        return salaireBase;
    }

    public void setSalaireBase(BigDecimal salaireBase) {
        this.salaireBase = salaireBase;
    }

    public Integer getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(Integer pourcentage) {
        this.pourcentage = pourcentage;
    }
}
