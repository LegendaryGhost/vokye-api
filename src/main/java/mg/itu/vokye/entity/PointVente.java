package mg.itu.vokye.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PointVente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPointVente;
    @ManyToOne
    @JoinColumn(name = "id_chariot")
    private Chariot chariot;
    private String localisation;
    private Double longitude;
    private Double latitude;
}
