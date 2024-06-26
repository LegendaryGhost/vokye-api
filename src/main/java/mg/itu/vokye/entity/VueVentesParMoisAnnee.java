package mg.itu.vokye.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "vue_ventes_par_mois_annee")
public class VueVentesParMoisAnnee {

    @Id
    @Column(name = "numero_ligne")
    private Long numeroLigne;

    @Column(name = "id_point_vente")
    private Long idPointVente;

    @Column(name = "localisation")
    private String localisation;

    @Column(name = "annee")
    private Integer annee;

    @Column(name = "mois")
    private Integer mois;

    @Column(name = "total_ventes_mois")
    private Double totalVentesMois;

    public VueVentesParMoisAnnee(){}
    public VueVentesParMoisAnnee(Long numeroLigne, Long idPointVente, String localisation, Integer annee, Integer mois, Double totalVentesMois) {
        this.numeroLigne = numeroLigne;
        this.idPointVente = idPointVente;
        this.localisation = localisation;
        this.annee = annee;
        this.mois = mois;
        this.totalVentesMois = totalVentesMois;
    }

    // Getters and Setters

    public Long getNumeroLigne() {
        return numeroLigne;
    }

    public void setNumeroLigne(Long numeroLigne) {
        this.numeroLigne = numeroLigne;
    }

    public Long getIdPointVente() {
        return idPointVente;
    }

    public void setIdPointVente(Long idPointVente) {
        this.idPointVente = idPointVente;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
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
}
