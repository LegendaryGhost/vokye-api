package mg.itu.vokye.controller;

import mg.itu.vokye.entity.TypeDepense;
import mg.itu.vokye.service.TypeDepenseService;

import org.springframework.data.domain.Page;
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
    @GetMapping("")
    public ResponseEntity<Page<TypeDepense>> getAll(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        Page<TypeDepense> typeDepenses = typeDepenseService.read(page, size);
        return ResponseEntity.ok(typeDepenses);
    }

    // Read one TypeDepense by ID
    @GetMapping("/{id}")
    public ResponseEntity<TypeDepense> getById(@PathVariable Integer id) {
        Optional<TypeDepense> typeDepense = typeDepenseService.getById(id);
        return typeDepense.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a TypeDepense by ID
    @PutMapping("/{id}")
    public ResponseEntity<TypeDepense> updateTypeDepense(@PathVariable Integer id, @RequestBody TypeDepense typeDepense) {
        TypeDepense td = typeDepenseService.update(id, typeDepense);
        return new ResponseEntity<>(td, HttpStatus.OK);
    }

    // Delete a TypeDepense by ID
    @DeleteMapping("/{id}")
    public void deleteTypeDepense(@PathVariable Integer id) {
        typeDepenseService.delete(id);
    }
}