package css.demo.espressodaggertesting.dagger;

import css.demo.espressodaggertesting.MainActivity;
import dagger.Component;

/**
 * Created by css on 2/18/17.
 */

@ActivityScope
@Component(dependencies = MainComponent.class, modules = {MainActivityPresenterModule.class})
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);

}
