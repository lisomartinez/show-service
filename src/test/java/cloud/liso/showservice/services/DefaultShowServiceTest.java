package cloud.liso.showservice.services;

import cloud.liso.showservice.exceptions.ShowNotFoundException;
import cloud.liso.showservice.model.Show;
import cloud.liso.showservice.repositories.ShowRepository;
import cloud.liso.showservice.utils.ShowFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DefaultShowServiceTest {

    @Mock
    private ShowRepository showRepository;

    private ShowService showService;

    @BeforeEach
    void setUp() {
        showService = new DefaultShowService(showRepository);
    }

    @Test
    void getShowById_validId_ReturnsShow() {
        Show expected = ShowFactory.getShowWithGenreAndSchedule(LocalDateTime.of(LocalDate.of(2010, 3, 12), LocalTime.of(22, 11, 11)), "Ended");
        when(showRepository.findById(anyInt())).thenReturn(Optional.of(expected));
        Show result = showService.getShowById(expected.getId());
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void getShowById_InvalidId_ThrowsShowNotFoundException() {
        when(showRepository.findById(anyInt())).thenReturn(Optional.empty());
        assertThrows(ShowNotFoundException.class, () -> showService.getShowById(Integer.MAX_VALUE));
    }
}