package mg.itu.vokye.controller;

import mg.itu.vokye.entity.TypeEmploye;
import mg.itu.vokye.service.TypeEmployeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<TypeEmploye> getAllTypeEmployes() {
        return service.getAllTypeEmployes();
    }

    // Find One
    @GetMapping("/{id}")
    public TypeEmploye getTypeEmployeById(@PathVariable int id) {
        return service.getTypeEmployeById(id);
    }

    // Update
    @PutMapping("/{id}")
    public TypeEmploye updateTypeEmploye(@RequestBody TypeEmploye typeEmploye, @PathVariable int id) {
        return service.updateTypeEmploye(id, typeEmploye);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteTypeEmploye(@PathVariable int id) {
        service.deleteTypeEmploye(id);
    }
}
