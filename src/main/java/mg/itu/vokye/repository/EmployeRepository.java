package mg.itu.vokye.repository;

import mg.itu.vokye.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM Employe e WHERE e.email = :email AND e.mot_de_passe = digest(:motDePasse, 'sha1')")
    boolean existsByEmailAndMotDePasse(@Param("email") String email, @Param("motDePasse") String motDePasse);
}
