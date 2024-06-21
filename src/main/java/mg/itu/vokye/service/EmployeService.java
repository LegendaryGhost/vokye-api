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
        existingEmploye.setGenre(employe.getGenre());
        existingEmploye.setMotDePasse(employe.getMotDePasse());
        existingEmploye.setEmail(employe.getEmail());
        existingEmploye.setPhoto(employe.getPhoto());
        return repository.save(existingEmploye);
    }

    public void deleteEmploye(Long id) {
        repository.deleteById(id);
    }

    public Employe checkEmploye(String email, String motDePasse) {
        return repository.existsByEmailAndMotDePasse(email, motDePasse);
    }

    public List<Employe> getEmployesByDesignation(String designation) {
        return repository.findByTypeEmployeDesignation(designation);
    }
}
