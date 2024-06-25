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

        @Query("SELECT new mg.itu.vokye.dto.EmployeDTO(e.nom, e.prenom, MAX(v.nb_ventes_mensuel) AS meilleurNombreVenteMensuel, " +
           "SUM(v.quantite * p.prix) AS meilleurChiffreAffaires, e.photo AS photo_de_profil) " +
           "FROM employe_performance e " +
           "JOIN ventes v ON e.idEmploye = v.idEmploye " +
           "JOIN produit p ON v.idProduit = p.idProduit " +
           "WHERE e.idEmploye = :idEmploye " +
           "GROUP BY e.idEmploye, e.nom, e.prenom, e.photo")
    EmployeDTO findEmployeStatsById(@Param("idEmploye") Long idEmploye);

 

}
