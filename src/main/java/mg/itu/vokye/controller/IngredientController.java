package mg.itu.vokye.controller;

import mg.itu.vokye.entity.Ingredient;
import mg.itu.vokye.service.IngredientService;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {
    private final IngredientService service;

    public IngredientController(IngredientService service) {
        this.service = service;
    }

    // Create
    @PostMapping
    public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
        return service.createIngredient(ingredient);
    }

    // Read All
    @GetMapping
    public Page<Ingredient> getAllIngredient(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return service.getAllIngredient(page, size);
    }

    // Find One
    @GetMapping("/{id}")
    public Ingredient getIngredientById(@PathVariable Long id) {
        return service.getIngredientById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Ingredient updateIngredient(@RequestBody Ingredient ingredient, @PathVariable Long id) {
        return service.updateIngredient(id, ingredient);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteIngredient(@PathVariable Long id) {
        service.deleteIngredient(id);
    }
}
