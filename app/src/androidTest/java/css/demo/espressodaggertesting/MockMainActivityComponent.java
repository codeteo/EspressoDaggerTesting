package css.demo.espressodaggertesting;

import css.demo.espressodaggertesting.dagger.ActivityScope;
import dagger.Component;

/**
 * Created by css on 2/18/17.
 */

@ActivityScope
@Component(dependencies = MockMainComponent.class,
        modules = {MockMainPresenterModule.class, MockGithubServiceModule.class})
public interface MockMainActivityComponent {

    void inject(MainActivityTest mainActivityTest);

}
