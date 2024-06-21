package mg.itu.vokye.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeStatsDTO {

    String nom;
    String prenom;
    Double recette;
    Double validcota;
    LocalDate in_date;
    Integer nombre_vente;

}
