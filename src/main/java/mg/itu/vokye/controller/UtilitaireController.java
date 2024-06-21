package mg.itu.vokye.controller;

import mg.itu.vokye.entity.Utilitaire;
import mg.itu.vokye.service.UtilitaireService;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/utilitaire")
public class UtilitaireController {
    private final UtilitaireService service;

    public UtilitaireController(UtilitaireService service) {
        this.service = service;
    }

    // Create
    @PostMapping
    public Utilitaire createUtilitaire(@RequestBody Utilitaire utilitaire) {
        return service.createUtilitaire(utilitaire);
    }

    // Read All
    @GetMapping
    public Page<Utilitaire> getAllUtilitaire(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return service.getAllUtilitaire(page, size);
    }

    // Find One
    @GetMapping("/{id}")
    public Utilitaire getUtilitaireById(@PathVariable Long id) {
        return service.getUtilitaireById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Utilitaire updateUtilitaire(@RequestBody Utilitaire utilitaire, @PathVariable Long id) {
        return service.updateUtilitaire(id, utilitaire);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteUtilitaire(@PathVariable Long id) {
        service.deleteUtilitaire(id);
    }
}
