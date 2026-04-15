package autogradertests;

import edu.coolschool.students.StudentRecord;
import edu.coolschool.utilities.PersonInfo;
import edu.coolschool.utilities.CountriesEnum;
import edu.coolschool.utilities.dateutils.DateRecord;
import edu.coolschool.utilities.dateutils.MonthsEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WrightShawnTest {

    @Test
    public void testNullStudentInfoThrows() {
        DateRecord enrollment = new DateRecord.Builder()
                .setDay(1)
                .setMonth(MonthsEnum.SEPTEMBER)
                .setYear(2020)
                .build();

        assertThrows(IllegalArgumentException.class, () -> {
            new StudentRecord.Builder()
                    .setStudentInfo(null)
                    .setStudentID("ABC123456")
                    .setEnrollmentDate(enrollment)
                    .build();
        });
    }

    @Test
    public void testInvalidBirthDateThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PersonInfo.Builder()
                    .setFirstName("Shawn")
                    .setLastName("Wright")
                    .setDateOfBirth(new DateRecord.Builder()
                            .setDay(32)
                            .setMonth(MonthsEnum.JANUARY)
                            .setYear(2010)
                            .build())
                    .setCountryOfResidence(CountriesEnum.US)
                    .setCountryOfBirth(CountriesEnum.US)
                    .build();
        });
    }

    @Test
    public void testValidEnrollmentYearStored() {
        PersonInfo student = new PersonInfo.Builder()
                .setFirstName("Shawn")
                .setLastName("Wright")
                .setDateOfBirth(new DateRecord.Builder()
                        .setDay(5)
                        .setMonth(MonthsEnum.MARCH)
                        .setYear(2005)
                        .build())
                .setCountryOfResidence(CountriesEnum.US)
                .setCountryOfBirth(CountriesEnum.US)
                .build();

        DateRecord enrollment = new DateRecord.Builder()
                .setDay(20)
                .setMonth(MonthsEnum.AUGUST)
                .setYear(2024)
                .build();

        StudentRecord record = new StudentRecord.Builder()
                .setStudentInfo(student)
                .setStudentID("XYZ987654")
                .setEnrollmentDate(enrollment)
                .build();

        assertEquals(2024, record.enrollmentDate().year());
    }
}