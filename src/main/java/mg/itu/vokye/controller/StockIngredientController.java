package mg.itu.vokye.controller;

import mg.itu.vokye.entity.StockIngredient;
import mg.itu.vokye.service.StockIngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock-ingredient")
public class StockIngredientController {
    private final StockIngredientService service;

    public StockIngredientController(StockIngredientService service) {
        this.service = service;
    }

    // Create
    @PostMapping
    public StockIngredient createStockIngredient(@RequestBody StockIngredient stockIngredient) {
        return service.createStockIngredient(stockIngredient);
    }

    // Read All
    @GetMapping
    public List<StockIngredient> getAllStockIngredients() {
        return service.getAllStockIngredient();
    }

    // Find One
    @GetMapping("/{id}")
    public StockIngredient getStockIngredientById(@PathVariable Long id) {
        return service.getStockIngredientById(id);
    }

    // Update
    @PutMapping("/{id}")
    public StockIngredient updateStockIngredient(@RequestBody StockIngredient stockIngredient, @PathVariable Long id) {
        return service.updateStockIngredient(id, stockIngredient);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteStockIngredient(@PathVariable Long id) {
        service.deleteStockIngredient(id);
    }
}