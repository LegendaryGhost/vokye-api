package mg.itu.vokye.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class GestionDTO {
    private Long id_point_vente;
    private String localisation;
    private double longitude;
    private double latitude;
    private Date date_vente;
    private Double total_ventes;

}
