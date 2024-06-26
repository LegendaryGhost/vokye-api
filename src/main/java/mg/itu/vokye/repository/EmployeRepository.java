package mg.itu.vokye.repository;

import mg.itu.vokye.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {

        @Query(value = "SELECT e.* " +
                        "FROM employe e " +
                        "INNER JOIN type_employe te ON e.id_type_employe = te.id_type_employe " +
                        "WHERE te.designation = 'Manager' " +
                        "AND e.mot_de_passe = crypt(:motDePasse, e.mot_de_passe) " +
                        "AND e.email = :email", nativeQuery = true)
        Employe existsByEmailAndMotDePasse(@Param("email") String email, @Param("motDePasse") String motDePasse);

        @Query(value = "SELECT * FROM employee WHERE designation = :designation", nativeQuery = true)
        List<Employe> findByDesignation(@Param("designation") String designation);
}
