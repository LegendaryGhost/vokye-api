package mg.itu.vokye.controller;

import mg.itu.vokye.entity.Etat;
import mg.itu.vokye.service.EtatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/etat")
public class EtatController {
    private final EtatService service;

    public EtatController(EtatService service) {
        this.service = service;
    }

    // Create
    @PostMapping
    public Etat createEtatUtilitaire(@RequestBody Etat etat) {
        return service.createEtat(etat);
    }

    // Read All
    @GetMapping
    public List<Etat> getAllEtatUtilitaire() {
        return service.getAllEtat();
    }

    // Find One
    @GetMapping("/{id}")
    public Etat getEtatUtilitaireById(@PathVariable Long id) {
        return service.getEtatById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Etat updateEtatUtilitaire(@RequestBody Etat etat, @PathVariable Long id) {
        return service.updateEtat(id, etat);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteEtatUtilitaire(@PathVariable Long id) {
        service.deleteEtat(id);
    }
}
