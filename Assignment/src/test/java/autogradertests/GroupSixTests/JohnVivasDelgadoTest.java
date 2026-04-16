package autogradertests.GroupSixTests;

import edu.coolschool.utilities.dateutils.DateRecord;
import edu.coolschool.utilities.dateutils.MonthsEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class JohnVivasDelgadoTest {

    @Test
    @DisplayName("DateRecord Builder rejects missing month")
    public void testDateRecordBuilderMissingMonth() {
        assertThrows(IllegalArgumentException.class, () -> {
            new DateRecord.Builder()
                    .setDay(15)
                    .setYear(2024)
                    .build();
        });
    }

    @Test
    @DisplayName("DateRecord Builder rejects missing year")
    public void testDateRecordBuilderMissingYear() {
        assertThrows(IllegalArgumentException.class, () -> {
            new DateRecord.Builder()
                    .setDay(15)
                    .setMonth(MonthsEnum.MARCH)
                    .build();
        });
    }

    @Test
    @DisplayName("DateRecord Builder rejects missing day")
    public void testDateRecordBuilderMissingDay() {
        assertThrows(IllegalArgumentException.class, () -> {
            new DateRecord.Builder()
                    .setMonth(MonthsEnum.MARCH)
                    .setYear(2024)
                    .build();
        });
    }
}