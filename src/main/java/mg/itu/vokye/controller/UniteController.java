package mg.itu.vokye.controller;

import mg.itu.vokye.entity.Unite;
import mg.itu.vokye.service.UniteService;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/unite")
public class UniteController {
    private final UniteService service;

    public UniteController(UniteService service) {
        this.service = service;
    }

    // Create
    @PostMapping
    public Unite createUnite(@RequestBody Unite unite) {
        return service.createUnite(unite);
    }

    // Read All
    @GetMapping
    public Page<Unite> getAllUnite(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return service.getAllUnite(page, size);
    }

    // Find One
    @GetMapping("/{id}")
    public Unite getUniteById(@PathVariable Long id) {
        return service.getUniteById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Unite updateUnite(@RequestBody Unite unite, @PathVariable Long id) {
        return service.updateUnite(id, unite);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteUnite(@PathVariable Long id) {
        service.deleteUnite(id);
    }
}
