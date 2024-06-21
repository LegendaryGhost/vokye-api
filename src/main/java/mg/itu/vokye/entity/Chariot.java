package mg.itu.vokye.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Chariot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChariot;
    @ManyToOne
    @JoinColumn(name = "id_employe")
    private Employe employe;
}
