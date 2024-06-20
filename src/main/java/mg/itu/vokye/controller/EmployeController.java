package mg.itu.vokye.controller;

import mg.itu.vokye.entity.Employe;
import mg.itu.vokye.service.EmployeService;
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
    public List<Employe> getAllEmployes() {
        return service.getAllEmployes();
    }

    // Find One
    @GetMapping("/{id}")
    public Employe getEmployeById(@PathVariable int id) {
        return service.getEmployeById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Employe updateEmploye(@RequestBody Employe employe, @PathVariable int id) {
        return service.updateEmploye(id, employe);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteEmploye(@PathVariable int id) {
        service.deleteEmploye(id);
    }

    // Get employees by position
    @GetMapping("/designation/{designation}")
    public List<Employe> getEmployesByDesignation(@PathVariable String designation) {
        return service.getEmployesByDesignation(designation);
    }
}
