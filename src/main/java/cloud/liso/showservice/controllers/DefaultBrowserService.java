package cloud.liso.showservice.controllers;

import cloud.liso.showservice.model.ShowCard;
import cloud.liso.showservice.repositories.ShowCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DefaultBrowserService implements BrowserService {

    private ShowCardRepository showCardRepository;

    public DefaultBrowserService(ShowCardRepository showCardRepository) {
        this.showCardRepository = showCardRepository;
    }

    @Override
    public Map<String, List<ShowCard>> getPortal() {
        List<ShowCard> all = showCardRepository.findAll();
        System.out.println("all = " + all);
        return all.stream().collect(Collectors.groupingBy(ShowCard::getGenre));
    }
}
