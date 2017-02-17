package css.demo.espressodaggertesting;

import org.joda.time.DateTime;

import javax.inject.Singleton;

/**
 * Created by css on 2/17/17.
 */
@Singleton
public class Clock {
    public DateTime getNow() {
        return new DateTime();
    }
}