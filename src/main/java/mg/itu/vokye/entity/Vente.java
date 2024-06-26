package mg.itu.vokye.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mg.itu.vokye.dto.EmployeStatsDTO;

import java.sql.Date;
import java.time.LocalDate;

@SqlResultSetMapping(name = "EmployeStatsDTOMapping", classes = @ConstructorResult(targetClass = EmployeStatsDTO.class, columns = {
                @ColumnResult(name = "nom", type = String.class),
                @ColumnResult(name = "prenom", type = String.class),
                @ColumnResult(name = "recette", type = Double.class),
                @ColumnResult(name = "validcota", type = Double.class),
                @ColumnResult(name = "in_date", type = LocalDate.class)
}))
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vente {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer id_vente;
        Integer id_point_vente;
        Integer id_chariot;
        Integer id_produit;
        Integer quantite;
        Date date_vente;

}
