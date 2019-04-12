package cloud.liso.showservice.services;

import cloud.liso.showservice.dto.ShowCardDto;
import cloud.liso.showservice.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class DefaultGenreService implements GenreService {

    private GenreRepository genreRepository;

    @Autowired
    public DefaultGenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Page<ShowCardDto> getPageByGenre(String name, int page, int size) {
        return genreRepository.findGenreByName(name, PageRequest.of(page, size));
    }
}
