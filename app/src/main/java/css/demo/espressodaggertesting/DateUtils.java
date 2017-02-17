package css.demo.espressodaggertesting;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by css on 2/17/17.
 */


public abstract class DateUtils {
    public static final DateTimeFormatter SHORT_DATE = DateTimeFormat.forPattern("yyyy-MM-dd");
    public static String format(DateTime dateTime) {
        return SHORT_DATE.print(dateTime);
    }
}
