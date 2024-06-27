package mg.itu.vokye.controller;

import mg.itu.vokye.dto.GestionDTO;
import mg.itu.vokye.entity.PointVente;
import mg.itu.vokye.service.PointVenteService;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import java.util.List;

@RestController
@RequestMapping("/api/pointVente")
public class PointVenteController {
    private final PointVenteService service;

    public PointVenteController(PointVenteService service) {
        this.service = service;
    }

    // Create
    @PostMapping
    public PointVente createPointVente(@RequestBody PointVente pointVente) {
        return service.createPointVente(pointVente);
    }

    // Read All
    @GetMapping
    public Page<PointVente> getAllPointVentes(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return service.getAllPointVente(page, size);
    }

    // Find One
    @GetMapping("/{id}")
    public PointVente getPointVenteById(@PathVariable Long id) {
        return service.getPointVenteById(id);
    }

    // Update
    @PutMapping("/{id}")
    public PointVente updatePointVente(@RequestBody PointVente pointVente, @PathVariable Long id) {
        return service.updatePointVente(id, pointVente);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deletePointVente(@PathVariable Long id) {
        service.deletePointVente(id);
    }

    @GetMapping("/vsp")
    public Page<GestionDTO> getStatPointVente(@RequestParam(defaultValue = "1") int page,
                                              @RequestParam(defaultValue = "10") int size) {
        return service.getStatsVentePoint(page, size);
    }
}