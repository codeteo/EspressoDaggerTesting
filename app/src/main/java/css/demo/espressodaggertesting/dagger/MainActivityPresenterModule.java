package css.demo.espressodaggertesting.dagger;

import css.demo.espressodaggertesting.MainMVP;
import dagger.Module;
import dagger.Provides;

/**
 * Module to provide View to Presenter for {@link css.demo.espressodaggertesting.MainActivity}
 */

@Module
public class MainActivityPresenterModule {

    MainMVP.View view;

    public MainActivityPresenterModule(MainMVP.View view) {
        this.view = view;
    }

    @Provides
    MainMVP.View providesMainView() {
        return view;
    }

}
