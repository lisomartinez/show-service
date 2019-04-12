package cloud.liso.showservice.services.imdb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class ImdbWebpageParserTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void parseWebpage() throws IOException {
        String expected = "vi3897206297";
        String content = Files.lines(Paths.get("src", "test", "resources", "imdb", "imdb.html")).collect(Collectors.joining());
        Webpage imdb = new Webpage(content);
        String result = new ImdbWebpageParser().parseWebpage(imdb);
        assertThat(result).isEqualTo(expected);
    }
}