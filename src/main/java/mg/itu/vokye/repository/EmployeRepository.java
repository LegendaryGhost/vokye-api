package mg.itu.vokye.repository;

import mg.itu.vokye.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
    List<Employe> findByPoste(String poste);
}
