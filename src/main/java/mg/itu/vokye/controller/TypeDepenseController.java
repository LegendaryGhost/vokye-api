package mg.itu.vokye.controller;

import mg.itu.vokye.entity.TypeDepense;
import mg.itu.vokye.service.TypeDepenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/typedepense")
public class TypeDepenseController {

    private final TypeDepenseService typeDepenseService;

    public TypeDepenseController(TypeDepenseService typeDepenseService) {
        this.typeDepenseService = typeDepenseService;
    }

    // Create a new TypeDepense
    @PostMapping
    public ResponseEntity<TypeDepense> createTypeDepense(@RequestBody TypeDepense typeDepense) {
        TypeDepense createdTypeDepense = typeDepenseService.create(typeDepense);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTypeDepense);
    }

    // Read all TypeDepenses
    @GetMapping("read")
    public ResponseEntity<List<TypeDepense>> getAllTypeDepenses() {
        List<TypeDepense> typeDepenses = typeDepenseService.read();
        return ResponseEntity.ok(typeDepenses);
    }

    // Read one TypeDepense by ID
    @GetMapping("/{id}")
    public ResponseEntity<TypeDepense> getTypeDepenseById(@PathVariable Integer id) {
        Optional<TypeDepense> typeDepense = typeDepenseService.getById(id);
        return typeDepense.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a TypeDepense by ID
    @PutMapping("")
    public ResponseEntity<TypeDepense> updateTypeDepense(@RequestBody TypeDepense typeDepense) {
        TypeDepense updatedTypeDepense = typeDepenseService.update(typeDepense);
        if (updatedTypeDepense != null) {
            return ResponseEntity.ok(updatedTypeDepense);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a TypeDepense by ID
    @DeleteMapping("/{id}")
    public void deleteTypeDepense(@PathVariable Integer id) {
        typeDepenseService.delete(id);
    }
}