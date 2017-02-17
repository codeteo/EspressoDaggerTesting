package css.demo.espressodaggertesting;

import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import javax.inject.Inject;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by css on 2/17/17.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Inject
    Clock clock;

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(
            MainActivity.class,
            true,     // initialTouchMode
            false);   // launchActivity. False so we can customize the intent per test method


    @Before
    public void setUp() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        MyApplication app
                = (MyApplication) instrumentation.getTargetContext().getApplicationContext();
        MockDemoComponent component = (MockDemoComponent) app.component();
        component.inject(this);
    }

    @Test
    public void today() {
        Mockito.when(clock.getNow()).thenReturn(new DateTime(2001, 9, 21, 0, 0, 0));

        activityRule.launchActivity(new Intent());

        onView(withId(R.id.date))
                .check(matches(withText("2001-09-21")));
    }


}
