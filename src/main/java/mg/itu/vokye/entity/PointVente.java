package mg.itu.vokye.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "point_vente")
public class PointVente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_point_vente;

    @ManyToOne
    @JoinColumn(name = "id_chariot")
    private Chariot chariot;

    private String localisation;
    private double longitude;
    private double latitude;

    // Getters and Setters
}
