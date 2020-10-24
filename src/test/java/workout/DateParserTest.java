package workout;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateParserTest {

    @Test
    void parseDate_correctFormat_returnParsedDate() {
        LocalDateTime dt = LocalDateTime.of(2020, 10, 22, 0, 0);
        String in1 = "2020/10/22";
        assertEquals(dt, DateParser.parseDate(in1));

        String in2 = "20201022";
        assertEquals(dt, DateParser.parseDate(in2));

        String in3 = "2020-10-22";
        assertEquals(dt, DateParser.parseDate(in3));

        String in4 = "2020 10 22";
        assertEquals(dt, DateParser.parseDate(in4));
    }

    @Test
    void parseDate_wrongFormat_returnNull() {
        LocalDateTime dt = LocalDateTime.of(2020, 10, 22, 0, 0);
        String in1 = "2020:10:22";
        assertEquals(null, DateParser.parseDate(in1));

    }
}