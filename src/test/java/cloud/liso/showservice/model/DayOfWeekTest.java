package cloud.liso.showservice.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DayOfWeekTest {

    @Test
    @DisplayName("Static Factory should return instance")
    void staticFactoryMethod_ReturnsInstance() {
        assertThat(DayOfWeek.MONDAY).isEqualTo("Monday");
    }
}