package cloud.liso.showservice.services.imdb;

import cloud.liso.showservice.exceptions.ImdbNotAvailableException;
import cloud.liso.showservice.exceptions.ShowNotFoundException;
import cloud.liso.showservice.repositories.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class HttpImdbService implements ImdbService {

    private static final String NOT_AVAILABLE = "N/A";
    public static final String IMDB_BASE_URL = "https://www.imdb.com/videoembed/";

    private WebClient client;
    private WebpageParser parse;
    private ShowRepository showRepository;

    @Autowired
    public HttpImdbService(WebClient client, WebpageParser parse, ShowRepository showRepository) {
        this.client = client;
        this.parse = parse;
        this.showRepository = showRepository;
    }

    @Override
    @Cacheable("imdb")
    public String getImdbVideoLink(int showId) {
        String imdbURL = showRepository.getImdbURL(showId).orElseThrow(() -> new ShowNotFoundException("Show id=" + showId + " not found"));
        if (imdbURL.equals(NOT_AVAILABLE)) {
            throw new ImdbNotAvailableException("Show id=" + showId + "has not a imdb link");
        } else {
            Webpage webpage = client.fetchWebpage(imdbURL);
            return IMDB_BASE_URL + parse.parseWebpage(webpage);
        }
    }
}
