package mg.itu.vokye.controller;

import mg.itu.vokye.entity.TypeEmploye;
import mg.itu.vokye.service.TypeEmployeService;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/type-employe")
public class TypeEmployeController {
    private final TypeEmployeService service;

    public TypeEmployeController(TypeEmployeService service) {
        this.service = service;
    }

    // Create
    @PostMapping
    public TypeEmploye createTypeEmploye(@RequestBody TypeEmploye typeEmploye) {
        return service.createTypeEmploye(typeEmploye);
    }

    // Read All
    @GetMapping
    public Page<TypeEmploye> getAllTypeEmploye(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return service.getAllTypeEmploye(page, size);
    }

    // Find One
    @GetMapping("/{id}")
    public TypeEmploye getTypeEmployeById(@PathVariable Long id) {
        return service.getTypeEmployeById(id);
    }

    // Update
    @PutMapping("/{id}")
    public TypeEmploye updateTypeEmploye(@RequestBody TypeEmploye typeEmploye, @PathVariable Long id) {
        return service.updateTypeEmploye(id, typeEmploye);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteTypeEmploye(@PathVariable Long id) {
        service.deleteTypeEmploye(id);
    }
}
