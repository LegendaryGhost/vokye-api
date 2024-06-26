package mg.itu.vokye.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeStatsDTO {

    String nom;
    String prenom;
    Double recette;
    Double validcota;
    Date in_date;
    Integer nombre_vente;

}
