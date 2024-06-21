package mg.itu.vokye.controller;

import mg.itu.vokye.entity.Employe;
import mg.itu.vokye.service.EmployeService;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/employe")
public class EmployeController {
    private final EmployeService service;

    public EmployeController(EmployeService service) {
        this.service = service;
    }

    // Create
    @PostMapping
    public Employe createEmploye(@RequestBody Employe employe) {
        return service.createEmploye(employe);
    }

    // Read All
    @GetMapping
    public Page<Employe> getAllEmploye(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return service.getAllEmploye(page, size);
    }

    // Find One
    @GetMapping("/{id}")
    public Employe getEmployeById(@PathVariable Long id) {
        return service.getEmployeById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Employe updateEmploye(@RequestBody Employe employe, @PathVariable Long id) {
        return service.updateEmploye(id, employe);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteEmploye(@PathVariable Long id) {
        service.deleteEmploye(id);
    }

    @GetMapping("/checkEmploye")
    public Employe checkEmploye(@RequestParam String email, @RequestParam String motDePasse) {
        return service.checkEmploye(email, motDePasse);
    }

    // Get employees by designation
    @GetMapping("/designation/{designation}")
    public List<Employe> getEmployesByDesignation(@PathVariable String designation) {
        return service.getEmployesByDesignation(designation);
    }

}
