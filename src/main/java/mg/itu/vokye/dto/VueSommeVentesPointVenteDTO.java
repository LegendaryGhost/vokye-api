package mg.itu.vokye.dto;

public class VueSommeVentesPointVenteDTO {
    private Long idPointVente;
    private String localisation;
    private Double totalVentes;

    // Constructor with parameters
    public VueSommeVentesPointVenteDTO(Long idPointVente, String localisation, Double totalVentes) {
        this.idPointVente = idPointVente;
        this.localisation = localisation;
        this.totalVentes = totalVentes;
    }

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

    public Double getTotalVentes() {
        return totalVentes;
    }

    public void setTotalVentes(Double totalVentes) {
        this.totalVentes = totalVentes;
    }
}
