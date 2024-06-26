package mg.itu.vokye.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "vue_chiffre_affaire")
public class ChiffreAffaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    double total;
}
