package mg.itu.vokye.controller;

import mg.itu.vokye.entity.Genres;
import mg.itu.vokye.service.GenresService;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/genres")
public class GenresController {
    private final GenresService service;

    public GenresController(GenresService service) {
        this.service = service;
    }

    // Create
    @PostMapping
    public Genres createGenres(@RequestBody Genres genres) {
        return service.createGenres(genres);
    }

    // Read All
    @GetMapping
    public Page<Genres> getAllGenres(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return service.getAllGenres(page, size);
    }

    // Find One
    @GetMapping("/{id}")
    public Genres getGenresById(@PathVariable Long id) {
        return service.getGenresById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Genres updateGenres(@RequestBody Genres genres, @PathVariable Long id) {
        return service.updateGenres(id, genres);
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteGenres(@PathVariable Long id) {
        service.deleteGenres(id);
    }
}
