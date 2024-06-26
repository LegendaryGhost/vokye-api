package mg.itu.vokye.service;

import mg.itu.vokye.entity.Chariot;
import mg.itu.vokye.repository.ChariotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChariotService {
    @Autowired
    private ChariotRepository chariotRepository;

    // Create
    public Chariot createChariot(Chariot chariot) {
        return chariotRepository.save(chariot);
    }

    // Read all with pagination
    public Page<Chariot> getAllChariot(int page, int size) {
        return chariotRepository.findAll(PageRequest.of(page, size));
    }

    // Read by ID
    public Chariot getChariotById(Long id) {
        return chariotRepository.findById(id).orElseThrow(() -> new RuntimeException("Chariot not found"));
    }

    // Update
    public Chariot updateChariot(Chariot chariotDetails) {
        Chariot chariot = chariotRepository.findById(chariotDetails.getId_chariot()).orElseThrow(() -> new RuntimeException("Chariot not found"));

        chariot.setEmploye(chariotDetails.getEmploye());
        // Update other fields if there are any

        return chariotRepository.save(chariot);
    }

    // Delete
    public void deleteChariot(Long id) {
        Chariot chariot = chariotRepository.findById(id).orElseThrow(() -> new RuntimeException("Chariot not found"));
        chariotRepository.delete(chariot);
    }
}
