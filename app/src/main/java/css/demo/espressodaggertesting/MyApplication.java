package css.demo.espressodaggertesting;

import android.app.Application;

import css.demo.espressodaggertesting.dagger.DaggerMainComponent;
import css.demo.espressodaggertesting.dagger.MainComponent;

/**
 * Created by css on 2/17/17.
 */

public class MyApplication extends Application {

    private final MainComponent demoComponent = createComponent();

    protected MainComponent createComponent() {
        return DaggerMainComponent.builder()
                .build();
    }

    public MainComponent component() {
        return demoComponent;
    }

}
