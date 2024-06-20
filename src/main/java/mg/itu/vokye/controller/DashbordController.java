package mg.itu.vokye.controller;

import mg.itu.vokye.service.DepenseService;
import mg.itu.vokye.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/dashbord")
public class DashbordController {
    @Autowired
    private DepenseService depenseService;
    @Autowired
    private VenteService venteService;

    @GetMapping("/venteToday")
    public ResponseEntity<Double> venteNow(){
        LocalDate today = LocalDate.now();
        return ResponseEntity.ok(venteService.getCountVente(today));
    }

}
