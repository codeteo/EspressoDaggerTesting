package css.demo.espressodaggertesting.dagger;

import javax.inject.Singleton;

import css.demo.espressodaggertesting.MainActivity;
import dagger.Component;

/**
 * Created by css on 2/18/17.
 */
@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
