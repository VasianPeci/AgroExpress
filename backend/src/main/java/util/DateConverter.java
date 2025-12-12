package util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Utility class for converting between legacy {@link java.util.Date}
 * and modern Java Time API classes: {@link LocalDate} and {@link LocalDateTime}.
 */
public class DateConverter {

    /**
     * Default system time zone used for conversions.
     */
    private static final ZoneId DEFAULT_ZONE_ID = ZoneId.systemDefault();

    /**
     * Converts a {@link LocalDate} to a {@link Date}.
     * The time is set to the start of the day (00:00) in the system default time zone.
     *
     * @param localDate the LocalDate to convert; may be null
     * @return a Date representing the same day, or null if input is null
     */
    public static Date toUtilDate(LocalDate localDate) {
        if (localDate == null) {
            return null;
        }
        return Date.from(localDate.atStartOfDay(DEFAULT_ZONE_ID).toInstant());
    }

    /**
     * Converts a {@link LocalDateTime} to a {@link Date}.
     * The LocalDateTime is interpreted in the system default time zone.
     *
     * @param localDateTime the LocalDateTime to convert; may be null
     * @return a Date representing the same moment in time, or null if input is null
     */
    public static Date toUtilDate(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        return Date.from(localDateTime.atZone(DEFAULT_ZONE_ID).toInstant());
    }

    /**
     * Converts a {@link Date} to a {@link LocalDate}.
     * The time zone used for interpretation is the system default.
     *
     * @param date the Date to convert; may be null
     * @return a LocalDate representing the same date, or null if input is null
     */
    public static LocalDate toLocalDate(Date date) {
        if (date == null) {
            return null;
        }
        return date.toInstant().atZone(DEFAULT_ZONE_ID).toLocalDate();
    }

    /**
     * Converts a {@link Date} to a {@link LocalDateTime}.
     * The time zone used for interpretation is the system default.
     *
     * @param date the Date to convert; may be null
     * @return a LocalDateTime representing the same moment, or null if input is null
     */
    public static LocalDateTime toLocalDateTime(Date date) {
        if (date == null) {
            return null;
        }
        return date.toInstant().atZone(DEFAULT_ZONE_ID).toLocalDateTime();
    }
}