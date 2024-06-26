package mg.itu.vokye.repository;

import mg.itu.vokye.entity.VueVentesParMoisAnnee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VueVentesParMoisAnneeRepository extends JpaRepository<VueVentesParMoisAnnee, Long> {

    @Query("SELECT new mg.itu.vokye.entity.VueVentesParMoisAnnee(v.numeroLigne, v.idPointVente, v.localisation, v.annee, v.mois, v.totalVentesMois) " +
            "FROM VueVentesParMoisAnnee v " +
            "WHERE v.idPointVente = ?1")
    List<VueVentesParMoisAnnee> findByIdPointVente(Long id);

    @Query("SELECT new mg.itu.vokye.entity.VueVentesParMoisAnnee(v.numeroLigne, v.idPointVente, v.localisation, v.annee, v.mois, v.totalVentesMois) " +
            "FROM VueVentesParMoisAnnee v " +
            "WHERE v.idPointVente = ?1 AND v.totalVentesMois = (" +
            "SELECT MAX(v2.totalVentesMois) FROM VueVentesParMoisAnnee v2 WHERE v2.idPointVente = ?1" +
            ")")
    List<VueVentesParMoisAnnee> findTopVenteMoisById(Long id);
}
