package cloud.liso.showservice.services;

import cloud.liso.showservice.dto.ShowCardDto;
import cloud.liso.showservice.model.Show;
import cloud.liso.showservice.model.ShowCard;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ShowService {

    Show getShowById(int showId);

    Page<Show> getShowPage(int page, int size);

    Page<ShowCardDto> getShowCardPage(int page, int size);

    List<ShowCard> getShowCards();

}
