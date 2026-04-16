package autogradertests;

import edu.coolschool.students.StudentRecord;
import edu.coolschool.utilities.PersonInfo;
import edu.coolschool.utilities.CountriesEnum;
import edu.coolschool.utilities.dateutils.DateRecord;
import edu.coolschool.utilities.dateutils.MonthsEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BhandariPriyankaTest {

    @Test
    public void testGetCode() {
        assertEquals("US", CountriesEnum.US.getCode());
        assertEquals("GB", CountriesEnum.GB.getCode());
        assertEquals("CA", CountriesEnum.CA.getCode());
    }

    @Test
    public void testGetDisplayName() {
        assertEquals("United States of America", CountriesEnum.US.getDisplayName());
        assertEquals("Canada", CountriesEnum.CA.getDisplayName());
        assertEquals("Mexico", CountriesEnum.MX.getDisplayName());
    }

    @Test
    public void testToString() {
        assertEquals("Japan", CountriesEnum.JP.toString());
        assertEquals("Brazil", CountriesEnum.BR.toString());
        assertEquals("Australia", CountriesEnum.AU.toString());
    }

    @Test
    public void testFromCode() {
        assertEquals(CountriesEnum.FR, CountriesEnum.fromCode("FR"));
        assertEquals(CountriesEnum.DE, CountriesEnum.fromCode("de")); // case insensitive
        assertEquals(CountriesEnum.IN, CountriesEnum.fromCode("IN"));
    }

    @Test
    public void testFromCodeInvalid() {
        assertThrows(IllegalArgumentException.class, () -> {
            CountriesEnum.fromCode("XX");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            CountriesEnum.fromCode("ZZ");
        });
    }
}
