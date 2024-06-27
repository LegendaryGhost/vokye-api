package mg.itu.vokye.controller;

import mg.itu.vokye.entity.Chariot;
import mg.itu.vokye.service.ChariotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chariot")
public class ChariotController {
    @Autowired
    ChariotService chariotService;

    @PostMapping
    public Chariot create(@RequestBody Chariot chariot) {
        return chariotService.createChariot(chariot);
    }

    @GetMapping
    public ResponseEntity<Page<Chariot>> getAllChariot(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(chariotService.getAllChariot(page, size));
    }

    @GetMapping("/{id}")
    public Chariot getAllChariotById(@PathVariable Long id) {
        return chariotService.getChariotById(id);
    }

    @PutMapping("")
    public Chariot update(@RequestBody Chariot chariot) {
        return chariotService.updateChariot(chariot);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        chariotService.deleteChariot(id);
    }

}
