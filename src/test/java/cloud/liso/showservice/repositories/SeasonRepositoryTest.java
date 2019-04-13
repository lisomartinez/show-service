package cloud.liso.showservice.repositories;

import cloud.liso.showservice.exceptions.SeasonNotFoundException;
import cloud.liso.showservice.model.Season;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class SeasonRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private SeasonRepository seasonRepository;


    @Test
    void getAllSeasons() {
        List<Season> showOne = seasonRepository.findAllByShow(1);
        showOne.stream().map(Season::getShow).forEach(show -> assertThat(show.getId()).isEqualTo(1));
    }

    @Test
    void getSeasonByShowId() {
        Season season = seasonRepository.getSeasonsByShowId(1, 3).orElseThrow(() -> new SeasonNotFoundException());
        assertThat(season.getShow().getId()).isEqualTo(1);
        assertThat(season.getNumber()).isEqualTo(3);
    }
}