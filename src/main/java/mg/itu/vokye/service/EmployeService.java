package mg.itu.vokye.service;

import mg.itu.vokye.entity.Employe;
import mg.itu.vokye.repository.EmployeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService {
    private final EmployeRepository repository;

    public EmployeService(EmployeRepository repository) {
        this.repository = repository;
    }

    public Employe createEmploye(Employe employe) {
        return repository.save(employe);
    }

    public List<Employe> getAllEmployes() {
        return repository.findAll();
    }

    public Employe getEmployeById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Employe updateEmploye(Long id, Employe employe) {
        Employe existingEmploye = repository.findById(id).orElseThrow();
        existingEmploye.setNom(employe.getNom());
        existingEmploye.setPrenom(employe.getPrenom());
        existingEmploye.setDateEntree(employe.getDateEntree());
        existingEmploye.setDateFin(employe.getDateFin());
        existingEmploye.setTypeEmploye(employe.getTypeEmploye());
        return repository.save(existingEmploye);
    }

    public void deleteEmploye(Long id) {
        repository.deleteById(id);
    }

    public boolean checkEmploye(String motDePasse, String email) {
        return repository.existsByEmailAndMotDePasse(email, motDePasse);
    }
}
