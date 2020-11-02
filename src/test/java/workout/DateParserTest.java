package workout;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DateParserTest {

    @Test
    void parseDate_correctFormat_returnParsedDate() {
        LocalDateTime dt = LocalDateTime.of(2020, 10, 22, 0, 0);

        String in1 = "20201022";
        assertEquals(dt, DateParser.parseDate(in1));

        String in2 = "2020-10-22";
        assertEquals(dt, DateParser.parseDate(in2));

        String in3 = "2020 10 22";
        assertEquals(dt, DateParser.parseDate(in3));
    }

    @Test
    void parseDate_wrongFormat_returnNull() {
        String in1 = "2020:10:22";
        assertNull(DateParser.parseDate(in1));

    }

    @Test
    void parseDate_invalidDate_returnNull() {
        String in1 = "20202131";
        assertNull(DateParser.parseDate(in1));

    }
}