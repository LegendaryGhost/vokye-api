package mg.itu.vokye.repository;

import mg.itu.vokye.dto.VueSommeVentesPointVenteDTO;
import mg.itu.vokye.entity.VueSommeVentesPointVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VueSommeVentesPointVenteRepository extends JpaRepository<VueSommeVentesPointVente, Long> {

    @Query("SELECT new mg.itu.vokye.dto.VueSommeVentesPointVenteDTO(v.idPointVente, v.localisation, SUM(v.totalVentes)) " +
            "FROM VueSommeVentesPointVente v " +
            "GROUP BY v.idPointVente, v.localisation " +
            "ORDER BY SUM(v.totalVentes) DESC")
    List<VueSommeVentesPointVenteDTO> findAllVentes();

    @Query("SELECT new mg.itu.vokye.dto.VueSommeVentesPointVenteDTO(v.idPointVente, v.localisation, SUM(v.totalVentes)) " +
            "FROM VueSommeVentesPointVente v " +
            "WHERE v.dateVente BETWEEN :dateMin AND :dateMax " +
            "GROUP BY v.idPointVente, v.localisation " +
            "ORDER BY SUM(v.totalVentes) DESC")
    List<VueSommeVentesPointVenteDTO> findVentesBetweenDates(LocalDate dateMin, LocalDate dateMax);

    @Query("SELECT new mg.itu.vokye.dto.VueSommeVentesPointVenteDTO(v.idPointVente, v.localisation, SUM(v.totalVentes)) " +
            "FROM VueSommeVentesPointVente v " +
            "WHERE v.dateVente >= :dateMin " +
            "GROUP BY v.idPointVente, v.localisation " +
            "ORDER BY SUM(v.totalVentes) DESC")
    List<VueSommeVentesPointVenteDTO> findVentesFromDate(LocalDate dateMin);

    @Query("SELECT new mg.itu.vokye.dto.VueSommeVentesPointVenteDTO(v.idPointVente, v.localisation, SUM(v.totalVentes)) " +
            "FROM VueSommeVentesPointVente v " +
            "WHERE v.dateVente <= :dateMax " +
            "GROUP BY v.idPointVente, v.localisation " +
            "ORDER BY SUM(v.totalVentes) DESC")
    List<VueSommeVentesPointVenteDTO> findVentesUpToDate(LocalDate dateMax);
}
