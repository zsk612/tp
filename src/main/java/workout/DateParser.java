package workout;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Arrays;
import java.util.List;

public class DateParser {
    private static final List<DateTimeFormatter> dtFormaters = Arrays.asList(
            DateTimeFormatter.ofPattern("yyyyMMdd HH:mm").withResolverStyle(ResolverStyle.STRICT),
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").withResolverStyle(ResolverStyle.STRICT),
            DateTimeFormatter.ofPattern("yyyy MM dd HH:mm").withResolverStyle(ResolverStyle.STRICT),
            DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm").withResolverStyle(ResolverStyle.STRICT),
            DateTimeFormatter.ofPattern("yyyyMMdd HHmm").withResolverStyle(ResolverStyle.STRICT),
            DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm").withResolverStyle(ResolverStyle.STRICT),
            DateTimeFormatter.ofPattern("yyyy MM dd HHmm").withResolverStyle(ResolverStyle.STRICT),
            DateTimeFormatter.ofPattern("yyyy/MM/dd HHmm").withResolverStyle(ResolverStyle.STRICT)
    );
    private static final List<DateTimeFormatter> dFormaters = Arrays.asList(
            DateTimeFormatter.ofPattern("yyyyMMdd").withResolverStyle(ResolverStyle.STRICT),
            DateTimeFormatter.ofPattern("yyyy/MM/dd").withResolverStyle(ResolverStyle.STRICT),
            DateTimeFormatter.ofPattern("yyyy-MM-dd").withResolverStyle(ResolverStyle.STRICT),
            DateTimeFormatter.ofPattern("yyyy MM dd").withResolverStyle(ResolverStyle.STRICT),
            DateTimeFormatter.ofPattern("dd-MM-yyyy").withResolverStyle(ResolverStyle.STRICT),
            DateTimeFormatter.ofPattern("dd/MM/yyyy").withResolverStyle(ResolverStyle.STRICT),
            DateTimeFormatter.ofPattern("dd MM yyyy").withResolverStyle(ResolverStyle.STRICT),
            DateTimeFormatter.ofPattern("ddMMyyyy").withResolverStyle(ResolverStyle.STRICT)
    );

    /**
     * Parses a given string following one of the accepted format into date-time format.
     *
     * @param targetString String input to be parsed.
     * @return Parsed result in the form of LocalDateTime or null if no value parsing is found.
     */
    public static LocalDateTime parseDate(String targetString) {
        for (DateTimeFormatter dtf : dtFormaters) {
            try {
                return LocalDateTime.parse(targetString, dtf);
            } catch (DateTimeParseException e) {
                continue;
            }
        }

        for (DateTimeFormatter dtf : dFormaters) {
            try {
                return LocalDate.parse(targetString, dtf).atStartOfDay();
            } catch (DateTimeParseException e) {
                continue;
            }
        }

        return null;
    }
}
