package css.demo.espressodaggertesting;

import dagger.Module;
import dagger.Provides;

/**
 * Created by css on 2/18/17.
 */

@Module
public class MockMainPresenterModule {

    MainMVP.View view;

    public MockMainPresenterModule(MainMVP.View view) {
        this.view = view;
    }

    @Provides
    MainMVP.View providesMainView() {
        return view;
    }

}
