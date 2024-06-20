package mg.itu.vokye.repository;

import mg.itu.vokye.entity.Depense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface DepenseRepository extends JpaRepository<Depense,Integer> {
    @Query(value = "SELECT sum(prix) as sum " +
            "FROM depense " +
            "WHERE (cast(:dateDepense as date) IS NULL OR date_depense = cast(:dateDepense as date)) ",
            nativeQuery = true)
    Double getDepenseAll(@Param("dateDepense") LocalDate dateDepense);
}