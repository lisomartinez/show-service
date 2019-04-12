package cloud.liso.showservice.services;

import cloud.liso.showservice.dto.ShowCardDto;
import org.springframework.data.domain.Page;

public interface GenreService {
    Page<ShowCardDto> getPageByGenre(String name, int page, int size);
}
