package mg.itu.vokye.controller;

import mg.itu.vokye.service.VueVentesParMoisAnneeService;
import org.springframework.web.bind.annotation.*;
import mg.itu.vokye.entity.VueVentesParMoisAnnee;

import java.util.List;

@RestController
@RequestMapping("/api/vueVentesParMoisAnnee")
public class VueVentesParMoisAnneeController {
    private final VueVentesParMoisAnneeService service;

    public VueVentesParMoisAnneeController(VueVentesParMoisAnneeService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public List<VueVentesParMoisAnnee> getVentesByIdPointVente(@PathVariable Long id) {
        return service.getVentesByIdPointVente(id);
    }

    @GetMapping("/top/{id}")
    public List<VueVentesParMoisAnnee> getTopVenteMoisById(@PathVariable Long id) {
        return service.getTopVenteMoisById(id);
    }
}
