package mg.itu.vokye.controller;

import mg.itu.vokye.entity.VueGestion;
import mg.itu.vokye.service.VueGestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vue-gestion")
public class VueGestionController {

    private final VueGestionService service;

    public VueGestionController(VueGestionService service) {
        this.service = service;
    }

    @GetMapping("/{annee}")
    public List<VueGestion> getVueGestionByYear(@PathVariable Integer annee) {
        return service.getGestionByYear(annee);
    }

    @GetMapping("/sum-depenses/{annee}")
    public Double getSumDepensesByYear(@PathVariable Integer annee) {
        return service.getSumDepensesByAnnee(annee);
    }

    @GetMapping("/sum-benefices/{annee}")
    public Double getSumBeneficesByYear(@PathVariable Integer annee) {
        return service.getSumBeneficesByAnnee(annee);
    }
}
