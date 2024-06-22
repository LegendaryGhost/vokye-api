package mg.itu.vokye.controller;

import mg.itu.vokye.entity.EtatUtilitaire;
import mg.itu.vokye.service.EtatUtilitaireService;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/etat-utilitaire")
public class EtatUtilitaireController {
    private final EtatUtilitaireService service;

    public EtatUtilitaireController(EtatUtilitaireService service) {
        this.service = service;
    }

    // Create
    @PostMapping
    public EtatUtilitaire createEtatUtilitaire(@RequestBody EtatUtilitaire etatUtilitaire) {
        return service.createEtatUtilitaire(etatUtilitaire);
    }

    // Read All
    @GetMapping
    public Page<EtatUtilitaire> getAllEtatUtilitaire(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return service.getAllEtatUtilitaire(page, size);
    }

    // Find One
    @GetMapping("/{id}")
    public EtatUtilitaire getEtatUtilitaireById(@PathVariable Long id) {
        return service.getEtatUtilitaireById(id);
    }

    // Update
    @PutMapping("/{id}")
    public EtatUtilitaire updateEtatUtilitaire(@RequestBody EtatUtilitaire etatUtilitaire, @PathVariable Long id) {
        return service.updateEtatUtilitaire(id, etatUtilitaire);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteEtatUtilitaire(@PathVariable Long id) {
        service.deleteEtatUtilitaire(id);
    }
}
