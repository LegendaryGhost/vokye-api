package mg.itu.vokye.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    @ManyToOne
    @JoinColumn(name = "id_produit")
    private String nom;
    private double prix;
}
