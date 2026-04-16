package autogradertests.GroupSixTests;

import edu.coolschool.utilities.CountriesEnum;
import edu.coolschool.utilities.ErrorStrings;
import edu.coolschool.utilities.PersonInfo;
import edu.coolschool.utilities.dateutils.DateFormatOptionsEnum;
import edu.coolschool.utilities.dateutils.DateRecord;
import edu.coolschool.utilities.dateutils.MonthsEnum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JJJohnsonTest {

    @Test
    @DisplayName("CountriesEnum.fromCode should accept valid codes regardless of case")
    public void testCountriesEnumValidCaseInsensitive() {
        assertEquals(CountriesEnum.US, CountriesEnum.fromCode("US"));
        assertEquals(CountriesEnum.US, CountriesEnum.fromCode("us"));
        assertEquals(CountriesEnum.GB, CountriesEnum.fromCode("gB"));
    }

    @Test
    @DisplayName("CountriesEnum.fromCode should throw exception for invalid code")
    public void testCountriesEnumInvalidCodeThrows() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            CountriesEnum.fromCode("XX");
        });

        assertEquals(ErrorStrings.UNKNOWN_COUNTRY.toString(), ex.getMessage());
    }

    @Test
    @DisplayName("DateRecord should return default format when null format option is passed")
    public void testDateRecordNullFormatFallback() {
        DateRecord date = new DateRecord(9, MonthsEnum.OCTOBER, 2024);

        assertEquals("10/09/2024", date.toString());
        assertEquals("10/09/2024", date.toString(null));
    }

    @Test
    @DisplayName("DateRecord should correctly format month name style")
    public void testDateRecordMonthFormat() {
        DateRecord date = new DateRecord(25, MonthsEnum.DECEMBER, 2025);

        assertEquals("December 25, 2025",
                date.toString(DateFormatOptionsEnum.MONTH_DD_YYYY));
    }

    @Test
    @DisplayName("PersonInfo.toString should omit middle name when not provided")
    public void testPersonInfoToStringWithoutMiddleName() {
        PersonInfo person = new PersonInfo.Builder()
                .setFirstName("Justin")
                .setLastName("Johnson")
                .setDateOfBirth(new DateRecord(14, 4, 2003))
                .setCountryOfResidence(CountriesEnum.US)
                .setCountryOfBirth(CountriesEnum.US)
                .build();

        String output = person.toString();

        assertTrue(output.contains("First Name: Justin"));
        assertTrue(output.contains("Last Name: Johnson"));
        assertFalse(output.contains("Middle Name:"));
    }

    @Test
    @DisplayName("PersonInfo builder should throw when required fields are missing")
    public void testPersonInfoBuilderMissingFields() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PersonInfo.Builder()
                    .setFirstName("Justin")
                    // Missing required fields
                    .build();
        });
    }
}