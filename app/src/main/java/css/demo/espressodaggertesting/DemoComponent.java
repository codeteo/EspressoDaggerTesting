package css.demo.espressodaggertesting;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by css on 2/17/17.
 */
@Singleton
@Component(modules = DemoModule.class)
public interface DemoComponent {
    void inject(MainActivity mainActivity);
}
