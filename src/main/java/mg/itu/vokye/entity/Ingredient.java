package mg.itu.vokye.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIngredient;
    private String nom;
    @ManyToOne
    @JoinColumn(name = "id_unite")
    private Unite unite;
    private Double stock;
}
