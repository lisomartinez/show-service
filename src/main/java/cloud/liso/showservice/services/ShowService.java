package cloud.liso.showservice.services;

import cloud.liso.showservice.model.Show;
import org.springframework.data.domain.Page;

public interface ShowService {

    Show getShowById(int showId);

    Page<Show> getShowPage(int page, int size);

}
