package css.demo.espressodaggertesting;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.mock;

/**
 * Mock Module provides mock dependencies
 */

@Module
public class MockClockModule {

    @Provides
    @Singleton
    Clock provideClock() {
        return mock(Clock.class);
    }
}
