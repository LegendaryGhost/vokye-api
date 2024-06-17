package mg.itu.vokye.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class StockUtilitaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStockUtilitaire;
    @ManyToOne
    @JoinColumn(name = "id_stock_utilitaire")
    private Utilitaire utilitaire;
    private int quantite;
}
