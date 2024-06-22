package mg.itu.vokye.repository;

import mg.itu.vokye.entity.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface VenteRepository extends JpaRepository<Vente, Integer> {

//    @Query(value = "SELECT sum(sum_vente) " +
//            "FROM recette_vente " +
//            "WHERE id_employe = :employeeId " +
//            "AND (cast(:dateVente as date) IS NULL OR date_vente = cast(:dateVente as date)) " +
//            "group by id_employe",
//            nativeQuery = true)
//    Double getRecette(@Param("employeeId") Integer employeeId, @Param("dateVente") LocalDate dateVente);

    @Query(value = "SELECT sum(sum_vente) " +
            "FROM recette_vente " +
            "WHERE (cast(:dateVente as date) IS NULL OR date_vente = cast(:dateVente as date)) ",
            nativeQuery = true)
    Double getRecetteAll(@Param("dateVente") Date dateVente);


    @Query(value = "SELECT sum(sum_vente) " +
            "FROM recette_vente " +
            "WHERE date_vente > :dateVenteMin AND date_vente < :dateVenteMax ",
            nativeQuery = true)
    Double getRecetteInervalDate(@Param("dateVente") Date dateVenteMin,@Param("dateVente") Date dateVenteMax);




//// BENEFICE //
//    @Query(value = "SELECT SUM(sum_vente - cota )  AS sum_vente " +
//            "FROM recette_vente "+
//            "WHERE id_employe = :employeeId " +
//            "AND (cast(:dateVente as date) IS NULL OR date_vente = cast(:dateVente as date)) " +
//            "GROUP BY id_employe " +
//            "HAVING SUM(sum_vente - cota) > 0",
//            nativeQuery = true)
//    Double getBenefice(@Param("employeeId") Integer employeeId, @Param("dateVente") LocalDate dateVente);
//
//// PERTE //
//    @Query(value = "SELECT SUM(sum_vente - cota )  AS sum_vente " +
//            "FROM recette_vente "+
//            "WHERE id_employe = :employeeId " +
//            "AND (cast(:dateVente as date) IS NULL OR date_vente = cast(:dateVente as date)) " +
//            "GROUP BY id_employe " +
//            "HAVING SUM(sum_vente - cota) < 0",
//            nativeQuery = true)
//    Double getPerte(@Param("employeeId") Integer employeeId, @Param("dateVente") LocalDate dateVente);
//




@Query(value = "SELECT sum(sum_vente) " +
        "FROM recette_vente " +
        "WHERE extract('year',date_vente) = :year " +
        "AND extract('month',date_vente) = :month",
        nativeQuery = true)
Double getRecetteAllMensuel(@Param("month") Integer month,@Param("year") Integer year);

    @Query(value = "SELECT sum(sum_vente) " +
            "FROM recette_vente " +
            "WHERE (date_vente = :year) "+
            "GROUP BY extract('Month',date_vente)",
            nativeQuery = true)
    Double getRecetteByMonthThisYear(@Param("year") Integer year);

    // nombre de vente
@Query(value = "SELECT sum(nombre_vente) " +
        "FROM recette_vente "+
        "WHERE (cast(:dateVente as date) IS NULL OR date_vente = cast(:dateVente as date))",
        nativeQuery = true)
Double getCountVente(@Param("dateVente") Date dateVente);





}