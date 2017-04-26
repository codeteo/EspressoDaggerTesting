package css.demo.espressodaggertesting;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;

import css.demo.espressodaggertesting.helpers.TestServiceHelper;
import css.demo.espressodaggertesting.util.MockWebServerHelper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * UI tests for {@link MainActivity}
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    MyApplication application;


    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class, true, false);

    private MockWebServer server;
    private final MockWebServerHelper mockWebServerHelper = new MockWebServerHelper();

    @Before
    public void setUp() throws Exception {
        application = (MyApplication) getInstrumentation().getTargetContext().getApplicationContext();

        MockitoAnnotations.initMocks(this);
        server = mockWebServerHelper.initMockWebServer();

//        Espresso.registerIdlingResources(new BetterIdlingResource());
    }

    @Test
    public void testTextViewIsShowingResult() throws Exception {
        // given
        String responseFile = "response_200_ok.json";
        server.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody(TestServiceHelper.getStringFromFile(InstrumentationRegistry.getContext(), responseFile)));

        // when
        Intent intent = new Intent();
        activityTestRule.launchActivity(intent);

//        Espresso.registerIdlingResources(activityTestRule.getActivity().getCountingIdlingResource());

        // then
        onView(withId(R.id.tv_name)).check(matches(isDisplayed()));
        onView(withText("square")).check(matches(isDisplayed()));
    }

    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }

}
