package mg.itu.vokye.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "vue_gestion")
public class VueGestion {

    @Id
    @Column(name = "numero_ligne")
    private Long numeroLigne;

    @Column(name = "annee")
    private Integer annee;

    @Column(name = "mois")
    private Integer mois;

    @Column(name = "total_ventes_mois")
    private Double totalVentesMois;

    @Column(name = "total_depenses_mois")
    private Double totalDepensesMois;

    @Column(name = "benefice_mois")
    private Double beneficeMois;

    public VueGestion(){}
    public VueGestion(Long numeroLigne, Integer annee, Integer mois, Double totalVentesMois, Double totalDepensesMois, Double beneficeMois) {
        this.numeroLigne = numeroLigne;
        this.annee = annee;
        this.mois = mois;
        this.totalVentesMois = totalVentesMois;
        this.totalDepensesMois = totalDepensesMois;
        this.beneficeMois = beneficeMois;
    }
// Getters and Setters

    public Long getNumeroLigne() {
        return numeroLigne;
    }

    public void setNumeroLigne(Long numeroLigne) {
        this.numeroLigne = numeroLigne;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public Integer getMois() {
        return mois;
    }

    public void setMois(Integer mois) {
        this.mois = mois;
    }

    public Double getTotalVentesMois() {
        return totalVentesMois;
    }

    public void setTotalVentesMois(Double totalVentesMois) {
        this.totalVentesMois = totalVentesMois;
    }

    public Double getTotalDepensesMois() {
        return totalDepensesMois;
    }

    public void setTotalDepensesMois(Double totalDepensesMois) {
        this.totalDepensesMois = totalDepensesMois;
    }

    public Double getBeneficeMois() {
        return beneficeMois;
    }

    public void setBeneficeMois(Double beneficeMois) {
        this.beneficeMois = beneficeMois;
    }
}
