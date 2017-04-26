package css.demo.espressodaggertesting;

import android.app.Application;

import css.demo.espressodaggertesting.dagger.ApplicationComponent;
import css.demo.espressodaggertesting.dagger.ApplicationModule;
import css.demo.espressodaggertesting.dagger.DaggerApplicationComponent;

/**
 * Application class. Creates {@link ApplicationComponent}
 */

public class MyApplication extends Application {

    private static ApplicationComponent demoComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        demoComponent = createComponent();
    }

    protected ApplicationComponent createComponent() {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static ApplicationComponent component() {
        return demoComponent;
    }

}
