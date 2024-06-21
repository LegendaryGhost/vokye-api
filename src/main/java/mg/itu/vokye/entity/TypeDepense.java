package mg.itu.vokye.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TypeDepense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_type_depense;

    private String designation;
}
