package mg.itu.vokye.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmploye;
    @ManyToOne
    @JoinColumn(name = "id_type_employe")
    private TypeEmploye typeEmploye;
    private String nom;
    private String prenom;
    private String motDePasse;
    private Date dateEntree;
    private Date dateFin;

    // getters and setters
    public Long getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(Long idEmploye) {
        this.idEmploye = idEmploye;
    }

    public TypeEmploye getTypeEmploye() {
        return typeEmploye;
    }

    public void setTypeEmploye(TypeEmploye typeEmploye) {
        this.typeEmploye = typeEmploye;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Date getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}
