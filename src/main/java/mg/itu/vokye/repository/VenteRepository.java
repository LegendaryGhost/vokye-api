package mg.itu.vokye.repository;

import mg.itu.vokye.entity.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface VenteRepository extends JpaRepository<Vente, Integer> {

    @Query(value = "SELECT sum(sum_vente) " +
            "FROM recette_vente " +
            "WHERE id_employe = :employeeId " +
            "AND (cast(:dateVente as date) IS NULL OR date_vente = cast(:dateVente as date)) " +
            "group by id_employe",
            nativeQuery = true)
    Double getRecette(@Param("employeeId") Integer employeeId, @Param("dateVente") LocalDate dateVente);

    @Query(value = "SELECT sum(sum_vente) " +
            "FROM recette_vente " +
            "WHERE (cast(:dateVente as date) IS NULL OR date_vente = cast(:dateVente as date)) ",
            nativeQuery = true)
    Double getRecetteAll(@Param("dateVente") LocalDate dateVente);
// BENEFICE //
    @Query(value = "SELECT SUM(sum_vente - :cota )  AS sum_vente " +
            "FROM recette_vente "+
            "WHERE id_employe = :employeeId " +
            "AND (cast(:dateVente as date) IS NULL OR date_vente = cast(:dateVente as date)) " +
            "GROUP BY id_employe " +
            "HAVING SUM(sum_vente - :cota) > 0",
            nativeQuery = true)
    Double getBenefice(@Param("employeeId") Integer employeeId, @Param("cota") Double cota, @Param("dateVente") LocalDate dateVente);

// PERTE //
    @Query(value = "SELECT SUM(sum_vente - :cota )  AS sum_vente " +
            "FROM recette_vente "+
            "WHERE id_employe = :employeeId " +
            "AND (cast(:dateVente as date) IS NULL OR date_vente = cast(:dateVente as date)) " +
            "GROUP BY id_employe " +
            "HAVING SUM(sum_vente - :cota) < 0",
            nativeQuery = true)
    Double getPerte(@Param("employeeId") Integer employeeId, @Param("cota") Double cota, @Param("dateVente") LocalDate dateVente);

}