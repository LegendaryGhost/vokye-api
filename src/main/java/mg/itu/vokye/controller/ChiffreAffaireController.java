package mg.itu.vokye.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mg.itu.vokye.service.ChiffreAffaireService;
import java.sql.Date;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/api/chiffre_affaire")
public class ChiffreAffaireController {
    private ChiffreAffaireService service;

    public ChiffreAffaireController(ChiffreAffaireService service) {
        this.service = service;
    }

    //function that allways be used 
    public Date parseDate(String date)  {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            java.util.Date utilDate = sdf.parse(date);
            return new Date(utilDate.getTime());
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/produit")
    public double getTotalProduit(@RequestParam(name="date1") String d1, @RequestParam(name="date2") String d2) {
        Date date1 = this.parseDate(d1);
        Date date2 = this.parseDate(d2);
        return service.total_depense(date1, date2);
    }

    @GetMapping("/vente")
    public double getVente(@RequestParam(name="date1") String d1,@RequestParam(name="date2") String d2) {
        Date date1 = this.parseDate(d1);
        Date date2 = this.parseDate(d2);
        return service.total_vente(date1, date2);
    }

    @GetMapping//Get the value of the "ChiffreAffaire"
    public double getValue(@RequestParam(name="date1") String d1,@RequestParam(name="date2") String d2) {
        Date date1 = this.parseDate(d1);
        Date date2 = this.parseDate(d2);
        return service.chiffreAffaire(date1, date2);
    }
}
