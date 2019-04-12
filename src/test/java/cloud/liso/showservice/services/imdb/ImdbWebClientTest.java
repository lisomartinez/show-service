package cloud.liso.showservice.services.imdb;

import cloud.liso.showservice.exceptions.ImdbShowNotFoundException;
import cloud.liso.showservice.exceptions.ImdbWebClientErrorException;
import cloud.liso.showservice.utils.ShowFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ImdbWebClientTest {

    @Test
    void fetchWebpage_validURL_ReturnsWebPage() {
        Webpage response = new ImdbWebClient().fetchWebpage(ShowFactory.getImdb());
        assertThat(response.getContent().length()).isNotEqualTo(0);
    }

    @Test
    void fetchWebpage_invalidShowId_ThrowsImdbShowNotFoundException() {
        assertThrows(ImdbShowNotFoundException.class, () -> new ImdbWebClient().fetchWebpage("https://www.imdb.com/title/tt1553656111"));
    }

    @Test
    void fetchWebPage_invalidUrl_ThrowsImdbWebClientErrorException() {
        assertThrows(ImdbWebClientErrorException.class, () -> new ImdbWebClient().fetchWebpage("https://www.imdb.cm/title/tt1553656111"));
    }
}