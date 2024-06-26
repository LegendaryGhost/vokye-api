package mg.itu.vokye.service;

import mg.itu.vokye.entity.Genres;
import mg.itu.vokye.repository.GenresRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class GenresService {
    private final GenresRepository repository;

    public GenresService(GenresRepository repository) {
        this.repository = repository;
    }

    public Genres createGenres(Genres genres) {
        return repository.save(genres);
    }

    public Page<Genres> getAllGenres(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    public Genres getGenresById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Genres updateGenres(Long id, Genres genres) {
        Genres existingGenres = repository.findById(id).orElseThrow();
        existingGenres.setNomGenre(genres.getNomGenre());
        return repository.save(existingGenres);
    }

    public void deleteGenres(Long id) {
        repository.deleteById(id);
    }
}
