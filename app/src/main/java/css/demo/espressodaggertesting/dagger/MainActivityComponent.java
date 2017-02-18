package css.demo.espressodaggertesting.dagger;

import css.demo.espressodaggertesting.MainActivity;
import dagger.Component;

/**
 * Created by css on 2/18/17.
 */

@ActivityScope
@Component( modules = {MainActivityPresenterModule.class})
public interface MainActivityComponent {

}
