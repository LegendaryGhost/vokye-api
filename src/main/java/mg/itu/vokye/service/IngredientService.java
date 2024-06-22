package mg.itu.vokye.service;

import mg.itu.vokye.entity.Ingredient;
import mg.itu.vokye.repository.IngredientRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
    private final IngredientRepository repository;

    public IngredientService(IngredientRepository repository) {
        this.repository = repository;
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        return repository.save(ingredient);
    }

    public Page<Ingredient> getAllIngredient(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    public Ingredient getIngredientById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Ingredient updateIngredient(Long id, Ingredient ingredient) {
        Ingredient existingIngredient = repository.findById(id).orElseThrow();
        existingIngredient.setNom(ingredient.getNom());
        existingIngredient.setUnite(ingredient.getUnite());
        existingIngredient.setStock(ingredient.getStock());
        return repository.save(existingIngredient);
    }

    public void deleteIngredient(Long id) {
        repository.deleteById(id);
    }
}
