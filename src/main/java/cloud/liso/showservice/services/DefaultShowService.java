package cloud.liso.showservice.services;

import cloud.liso.showservice.exceptions.ShowNotFoundException;
import cloud.liso.showservice.model.Show;
import cloud.liso.showservice.repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class DefaultShowService implements ShowService {

    private ShowRepository showRepository;

    @Autowired
    public DefaultShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @Override
    public Show getShowById(int showId) {
        return showRepository.findById(showId).orElseThrow(() -> new ShowNotFoundException("show id =" + showId));
    }

    @Override
    public Page<Show> getShowPage(int page, int size) {
        return showRepository.findAll(PageRequest.of(page, size));
    }

}
