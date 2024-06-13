package mg.itu.vokye.controller;

import mg.itu.vokye.entity.Employe;
import mg.itu.vokye.repository.EmployeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employe")
public class EmployeController {
    private final EmployeRepository repository;

    public EmployeController(EmployeRepository repository) {
        this.repository = repository;
    }

    // Create
    @PostMapping
    public Employe createEmploye(@RequestBody Employe employe) {
        return repository.save(employe);
    }

    // Read All
    @GetMapping
    public List<Employe> getAllEmployes() {
        return repository.findAll();
    }

    // Find One
    @GetMapping("/{id}")
    public Employe getEmployeById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    // Update
    @PutMapping("/{id}")
    public Employe updateEmploye(@RequestBody Employe employe, @PathVariable Long id) {
        Employe existingEmploye = repository.findById(id).orElseThrow();
        existingEmploye.setNom(employe.getNom());
        existingEmploye.setPrenom(employe.getPrenom());
        existingEmploye.setDateEntree(employe.getDateEntree());
        existingEmploye.setDateFin(employe.getDateFin());
        existingEmploye.setTypeEmploye(employe.getTypeEmploye());
        return repository.save(existingEmploye);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteEmploye(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
