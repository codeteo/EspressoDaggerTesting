package css.demo.espressodaggertesting.dagger;

import css.demo.espressodaggertesting.MainActivity;
import dagger.Component;

/**
 * Dagger Component. This one is needed to inject to {@link MainActivity}.
 */

@ActivityScope
@Component(dependencies = ApplicationComponent.class,
        modules = {MainActivityPresenterModule.class, GithubServiceModule.class})
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);

}
