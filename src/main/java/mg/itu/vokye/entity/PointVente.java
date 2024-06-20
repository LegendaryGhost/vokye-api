package mg.itu.vokye.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PointVente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPointVente;
    
    private String localisation;
    
    private Double longitude;
    
    private Double latitude;
}
