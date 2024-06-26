package mg.itu.vokye.repository;

import mg.itu.vokye.entity.VueGestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VueGestionRepository extends JpaRepository<VueGestion, Long> {

    @Query("SELECT SUM(v.totalDepensesMois) FROM VueGestion v WHERE v.annee = :annee")
    Double sumDepensesByAnnee(Integer annee);

    @Query("SELECT SUM(v.beneficeMois) FROM VueGestion v WHERE v.annee = :annee")
    Double sumBeneficesByAnnee(Integer annee);
    @Query("SELECT v FROM VueGestion v WHERE v.annee = :annee")
    List<VueGestion> findByAnnee(Integer annee);
}
