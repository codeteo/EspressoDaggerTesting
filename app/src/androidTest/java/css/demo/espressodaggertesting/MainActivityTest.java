package css.demo.espressodaggertesting;

import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.mockito.Mockito.mock;

/**
 * Created by css on 2/17/17.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(
            MainActivity.class,
            true,     // initialTouchMode
            false);   // launchActivity. False so we can customize the intent per test method

    @Inject
    MainActivityPresenter presenter;

    MainMVP.View view;

    @Before
    public void setUp() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        MyApplication app
                = (MyApplication) instrumentation.getTargetContext().getApplicationContext();

        MockMainComponent component = (MockMainComponent) app.component();
//        component.inject(this);

        view = mock(MainMVP.View.class);

        DaggerMockMainActivityComponent.builder()
                .mockMainComponent(component)
                .mockGithubServiceModule(new MockGithubServiceModule())
                .mockMainPresenterModule(new MockMainPresenterModule(view))
                .build()
                .inject(this);

    }

    @Test
    public void today() {

        activityRule.launchActivity(new Intent());

        onView(ViewMatchers.withId(R.id.name))
                .check(matches(isDisplayed()));

//        Mockito.when(clock.getNow()).thenReturn(new DateTime(2001, 9, 21, 0, 0, 0));

//        activityRule.launchActivity(new Intent());

//        onView(withId(R.id.date))
//                .check(matches(withText("2001-09-21")));
    }


}
