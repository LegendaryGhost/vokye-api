package mg.itu.vokye.controller;

import mg.itu.vokye.entity.StockUtilitaire;
import mg.itu.vokye.service.StockUtilitaireService;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stock-utilitaire")
public class StockUtilitaireController {
    private final StockUtilitaireService service;

    public StockUtilitaireController(StockUtilitaireService service) {
        this.service = service;
    }

    // Create
    @PostMapping
    public StockUtilitaire createStockUtilitaire(@RequestBody StockUtilitaire stockUtilitaire) {
        return service.createStockUtilitaire(stockUtilitaire);
    }

    // Read All
    @GetMapping
    public Page<StockUtilitaire> getAllStockUtilitaire(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return service.getAllStockUtilitaire(page, size);
    }

    // Find One
    @GetMapping("/{id}")
    public StockUtilitaire getStockUtilitaireById(@PathVariable Long id) {
        return service.getStockUtilitaireById(id);
    }

    // Update
    @PutMapping("/{id}")
    public StockUtilitaire updateStockUtilitaire(@RequestBody StockUtilitaire stockUtilitaire, @PathVariable Long id) {
        return service.updateStockUtilitaire(id, stockUtilitaire);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteStockUtilitaire(@PathVariable Long id) {
        service.deleteStockUtilitaire(id);
    }
}
