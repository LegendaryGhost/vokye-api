package mg.itu.vokye.controller;

import mg.itu.vokye.dto.VueSommeVentesPointVenteDTO;
import mg.itu.vokye.service.VueSommeVentesPointVenteService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/vueSommeVentesPointVente")
public class VueSommeVentesPointVenteController {
    private final VueSommeVentesPointVenteService service;

    public VueSommeVentesPointVenteController(VueSommeVentesPointVenteService service) {
        this.service = service;
    }

    @GetMapping
    public List<VueSommeVentesPointVenteDTO> getVentes(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateMin,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateMax) {
        if (dateMin != null && dateMax != null) {
            return service.getVentesBetweenDates(dateMin, dateMax);
        } else if (dateMin != null) {
            return service.getVentesFromDate(dateMin);
        } else if (dateMax != null) {
            return service.getVentesUpToDate(dateMax);
        } else {
            return service.getAllVentes();
        }
    }
}
