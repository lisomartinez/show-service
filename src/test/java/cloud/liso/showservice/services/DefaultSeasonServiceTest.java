package cloud.liso.showservice.services;

import cloud.liso.showservice.model.Season;
import cloud.liso.showservice.repositories.SeasonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DefaultSeasonServiceTest {

    @Mock
    private SeasonRepository seasonRepository;

    private SeasonService seasonService;

    @BeforeEach
    void setUp() {
        seasonService = new DefaultSeasonService(seasonRepository);
    }

    @Test
    void getAllSeasons() {
        when(seasonRepository.findAllByShow(anyInt())).thenReturn(Arrays.asList(new Season(), new Season(), new Season()));
        List<Season> allSeasons = seasonService.getAllSeasons(1);
        assertThat(allSeasons.size()).isEqualTo(3);
    }
}