package mg.itu.vokye.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "vue_somme_ventes_point_vente")
public class VueSommeVentesPointVente {

    @Id
    @Column(name = "numero_ligne")
    private Long numero_ligne;

    @Column(name = "id_point_vente")
    private Long idPointVente;


    @Column(name = "localisation")
    private String localisation;

    @Column(name = "date_vente")
    private LocalDate dateVente;

    @Column(name = "total_ventes")
    private Double totalVentes;

    // Getters and Setters

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

    public LocalDate getDateVente() {
        return dateVente;
    }

    public void setDateVente(LocalDate dateVente) {
        this.dateVente = dateVente;
    }

    public Double getTotalVentes() {
        return totalVentes;
    }

    public void setTotalVentes(Double totalVentes) {
        this.totalVentes = totalVentes;
    }
}