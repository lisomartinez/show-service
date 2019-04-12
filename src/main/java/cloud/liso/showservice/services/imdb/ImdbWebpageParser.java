package cloud.liso.showservice.services.imdb;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class ImdbWebpageParser implements WebpageParser {

    @Override
    public String parseWebpage(Webpage webpage) {
        Document document = Jsoup.parse(webpage.getContent());
        return document.select(".video-modal").attr("data-video");
    }
}
