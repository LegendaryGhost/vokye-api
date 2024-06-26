package mg.itu.vokye.service;

import mg.itu.vokye.entity.StockIngredient;
import mg.itu.vokye.repository.StockIngredientRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class StockIngredientService {
    private final StockIngredientRepository repository;

    public StockIngredientService(StockIngredientRepository repository) {
        this.repository = repository;
    }

    public StockIngredient createStockIngredient(StockIngredient stockIngredient) {
        return repository.save(stockIngredient);
    }

    public Page<StockIngredient> getAllStockIngredient(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    public StockIngredient getStockIngredientById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public StockIngredient updateStockIngredient(Long id, StockIngredient stockIngredient) {
        StockIngredient existingStockIngredient = repository.findById(id).orElseThrow();
        existingStockIngredient.setIngredient(stockIngredient.getIngredient());
        existingStockIngredient.setQuantite(stockIngredient.getQuantite());
        return repository.save(existingStockIngredient);
    }

    public void deleteStockIngredient(Long id) {
        repository.deleteById(id);
    }
}
