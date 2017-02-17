package css.demo.espressodaggertesting;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Dagger Component for androidTests extends DemoComponent
 * and injects to {@link MainActivityTest}
 */

@Singleton
@Component(modules = MockClockModule.class)
public interface MockDemoComponent extends DemoComponent {
    void inject(MainActivityTest mainActivityTest);
}
