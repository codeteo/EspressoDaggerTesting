package css.demo.espressodaggertesting;

import javax.inject.Singleton;

import css.demo.espressodaggertesting.dagger.MainComponent;
import dagger.Component;

/**
 * Dagger Component for androidTests extends DemoComponent
 * and injects to {@link MainActivityTest}
 */

@Singleton
@Component
public interface MockMainComponent extends MainComponent {
}
