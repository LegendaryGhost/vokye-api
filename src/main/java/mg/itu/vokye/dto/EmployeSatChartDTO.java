package mg.itu.vokye.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeSatChartDTO {
    private String nom;
    private String prenom;
    private int meilleurQuantiteVente;
    private double meilleurChiffreAffaires;
    private String photo_de_profil;
    private Date date;
}
