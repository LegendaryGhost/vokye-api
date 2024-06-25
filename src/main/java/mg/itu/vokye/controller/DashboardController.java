package mg.itu.vokye.controller;

import mg.itu.vokye.service.DepenseService;
import mg.itu.vokye.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.sql.Date;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
    @Autowired
    private DepenseService depenseService;
    @Autowired
    private VenteService venteService;

    @GetMapping("/venteToday")
    public ResponseEntity<Double> venteNow(){
        Date today = Date.valueOf(LocalDate.now());
        return ResponseEntity.ok(venteService.getCountVente(today));
    }

    @GetMapping("/benefice")
    public ResponseEntity<Double> benefice(@RequestParam Date date){
        Double benefice = depenseService.get_Benefice(date);
        return  ResponseEntity.ok(benefice);
    }

    @GetMapping("/beneficeMonth")
    public ResponseEntity<Double> beneficeMonth(@RequestParam Integer month,@RequestParam Integer year){
        Double benefice = depenseService.get_BeneficeMonth(month,year);
        return  ResponseEntity.ok(benefice);
    }



}
