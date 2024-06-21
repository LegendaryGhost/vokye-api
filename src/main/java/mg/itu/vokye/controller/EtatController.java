package mg.itu.vokye.controller;

import mg.itu.vokye.entity.Etat;
import mg.itu.vokye.service.EtatService;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/etat")
public class EtatController {
    private final EtatService service;

    public EtatController(EtatService service) {
        this.service = service;
    }

    // Create
    @PostMapping
    public Etat createEtat(@RequestBody Etat etat) {
        return service.createEtat(etat);
    }

    // Read All
    @GetMapping
    public Page<Etat> getAllEtat(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return service.getAllEtat(page, size);
    }

    // Find One
    @GetMapping("/{id}")
    public Etat getEtatById(@PathVariable Long id) {
        return service.getEtatById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Etat updateEtat(@RequestBody Etat etat, @PathVariable Long id) {
        return service.updateEtat(id, etat);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteEtat(@PathVariable Long id) {
        service.deleteEtat(id);
    }
}
