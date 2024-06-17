package mg.itu.vokye.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIngredient;
    @ManyToOne
    @JoinColumn(name = "id_ingredient")
    private String nom;
    private Unite unite;
}
