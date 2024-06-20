package mg.itu.vokye.repository;

import mg.itu.vokye.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Integer> {

    @Query(value = "SELECT * FROM employee WHERE designation = :designation", nativeQuery = true)
    List<Employe> findByDesignation(@Param("designation") String designation);
}
