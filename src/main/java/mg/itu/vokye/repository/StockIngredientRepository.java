package mg.itu.vokye.repository;

import mg.itu.vokye.entity.StockIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockIngredientRepository extends JpaRepository<StockIngredient, Long> {
}
