package mg.itu.vokye.entity;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVente;
    @ManyToOne
    @JoinColumn(name = "id_point_vente")
    private PointVente pointDeVente;
    @ManyToOne
    @JoinColumn(name = "id_chariot")
    private Chariot chariot;
    @ManyToOne
    @JoinColumn(name = "id_produit")
    private Produit produit;
    private Integer quantite;
    private Date dateVente;
}
