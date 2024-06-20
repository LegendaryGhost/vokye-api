package mg.itu.vokye.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "vente")
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vente;

    @ManyToOne
    @JoinColumn(name = "id_point_vente")
    private PointVente pointVente;

    @ManyToOne
    @JoinColumn(name = "id_chariot")
    private Chariot chariot;

    @ManyToOne
    @JoinColumn(name = "id_produit")
    private Produit produit;

    private int quantite;
    private Date date_vente;

    // Getters and Setters
}
