package mg.itu.vokye.entity;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class AchatIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAchatIngrdient;
    @ManyToOne
    @JoinColumn(name = "id_ingredient")
    private Ingredient ingredient;
    private Double prixUnitaire;
    private Integer quantite;
    private Date dateAchat;
    @ManyToOne
    @JoinColumn(name = "id_depense")
    private Depense depense;
}
