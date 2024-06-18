package mg.itu.vokye.repository;

import mg.itu.vokye.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

    @Query(value = "SELECT * " +
            "FROM employe e " +
            "WHERE e.email = :email " +
            "AND e.mot_de_passe = crypt(:motDePasse, e.mot_de_passe)", nativeQuery = true)
    Employe existsByEmailAndMotDePasse(@Param("email") String email, @Param("motDePasse") String motDePasse);
}
