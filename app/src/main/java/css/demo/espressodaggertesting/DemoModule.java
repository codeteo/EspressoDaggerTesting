package css.demo.espressodaggertesting;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by css on 2/17/17.
 */

@Module
public class DemoModule {

    @Provides
    @Singleton
    Clock provideClock() {
        return new Clock();
    }

}
