package mg.itu.vokye.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Unite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUnite;
    @ManyToOne
    @JoinColumn(name = "id_unite")
    private String nomUnite;
}
