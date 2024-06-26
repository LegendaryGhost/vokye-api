package mg.itu.vokye.repository;

import mg.itu.vokye.dto.EmployeDTO;
import mg.itu.vokye.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

        @Query(value = "SELECT e.* " +
                        "FROM employe e " +
                        "INNER JOIN type_employe te ON e.id_type_employe = te.id_type_employe " +
                        "WHERE te.designation = 'Manager' " +
                        "AND e.mot_de_passe = crypt(:motDePasse, e.mot_de_passe) " +
                        "AND e.email = :email", nativeQuery = true)
        Employe existsByEmailAndMotDePasse(@Param("email") String email, @Param("motDePasse") String motDePasse);

        // @SuppressWarnings("unchecked")
        // @Query(value = "INSERT INTO employe VALUE " +
        // "(default, :idEmploye, :nom, :prenom, :email, crypt(:motDePasse,
        // gen_salt('bf')), :dateEntree, :dateFin)")
        // Employe save(Employe e);

        @Query(value = "SELECT e.nom, e.prenom, e.photo_de_profil, " +
                   "e.meilleur_nombre_de_ventes_mensuel AS meilleurNombreVenteMensuel, " +
                   "e.meilleur_chiffre_d_affaires AS meilleurChiffreAffaires " +
                   "FROM employe_performance e " +
                   "WHERE e.id_employe = :idEmploye", nativeQuery = true)
    EmployeDTO findEmployeStatsById(@Param("idEmploye") Long idEmploye);

 

}
