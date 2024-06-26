package mg.itu.vokye.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mg.itu.vokye.dto.EmployeDTO;

import java.sql.Date;

@SqlResultSetMapping(
        name = "EmployeDTOMapping",
        classes = @ConstructorResult(
                targetClass = EmployeDTO.class,
                columns = {
                        @ColumnResult(name = "nom", type = String.class),
                        @ColumnResult(name = "prenom", type = String.class),
                        @ColumnResult(name = "photo_de_profil", type = String.class),
                        @ColumnResult(name = "meilleurNombreVenteMensuel", type = Integer.class),
                        @ColumnResult(name = "meilleurChiffreAffaires", type = Double.class)
                }
        )
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmploye;

    @ManyToOne
    @JoinColumn(name = "id_type_employe")
    private TypeEmploye typeEmploye;

    @ManyToOne
    @JoinColumn(name = "id_genre")
    private Genre genre;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email")
    private String email;

    @Column(name = "date_naissance")
    private Date dateNaissance;

    @Column(name = "num_tel")
    private int numTel;

    @Column(name = "date_entree")
    private Date dateEntree;

    @Column(name = "date_fin")
    private Date dateFin;

    @Column(name = "mot_de_passe")
    private String motDePasse;

    @Column(name = "photo")
    private String photo;
}
