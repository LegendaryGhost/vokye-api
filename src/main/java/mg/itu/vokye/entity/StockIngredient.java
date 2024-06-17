package mg.itu.vokye.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class StockIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStockIngredient;
    @ManyToOne
    @JoinColumn(name = "id_ingredient")
    private Ingredient ingredient;
    private int quantite;
}
