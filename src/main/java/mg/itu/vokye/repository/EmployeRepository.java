package mg.itu.vokye.repository;

import mg.itu.vokye.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Integer> {

    @Query("SELECT e FROM Employe e JOIN e.typeEmploye t WHERE t.designation = :designation")
    List<Employe> findByTypeEmployeDesignation(@Param("designation") String designation);
}
