package mg.itu.vokye.service;

import mg.itu.vokye.entity.TypeDepense;
import mg.itu.vokye.repository.TypeDepenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TypeDepenseService {
    @Autowired
    TypeDepenseRepository typeDepenseRepository;

    public TypeDepense create(TypeDepense typeDepense) {
        return typeDepenseRepository.save(typeDepense);
    }

    public List<TypeDepense> read() {
        return typeDepenseRepository.findAll();
    }

    public Optional<TypeDepense> getById(Integer id) {
        return typeDepenseRepository.findById(id);
    }

    public TypeDepense update(TypeDepense typeDepense) {
        Optional<TypeDepense> optionalTypeDepense = typeDepenseRepository.findById(typeDepense.getId_type_depense());
        if (optionalTypeDepense.isPresent()) {
            return typeDepenseRepository.save(typeDepense);
        }
        return null;
    }

    public void delete(Integer idTypeDepense) {
        typeDepenseRepository.deleteById(idTypeDepense);
    }


}