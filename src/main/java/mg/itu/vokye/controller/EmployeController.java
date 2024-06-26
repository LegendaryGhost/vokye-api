package mg.itu.vokye.controller;

import mg.itu.vokye.dto.EmployeDTO;
import mg.itu.vokye.dto.EmployeSatChartDTO;
import mg.itu.vokye.entity.Employe;
import mg.itu.vokye.service.EmployeService;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
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
    public Page<Employe> getAllEmploye(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
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

    @GetMapping("/{id}/stats")
    public EmployeDTO getEmployeStats(@PathVariable Long id) {
        return service.getEmployeStatsById(id);
    }
    @GetMapping("/{id}/stats/{annee}")
    public ResponseEntity<List<EmployeSatChartDTO>> getEmployeStats(@PathVariable Long id, @PathVariable Integer annee) {
        List<EmployeSatChartDTO> result = service.getEmployeStatsByDate(id,annee);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // Get employees by designation
//    @GetMapping("/designation/{designation}")
//    public List<Employe> getEmployesByDesignation(@PathVariable String designation) {
//        return service.getEmployesByDesignation(designation);
//    }

}
