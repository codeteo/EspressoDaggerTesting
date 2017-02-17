package css.demo.espressodaggertesting;

import android.app.Application;

/**
 * Created by css on 2/17/17.
 */

public class MyApplication extends Application {

    private final DemoComponent demoComponent = createComponent();

    protected DemoComponent createComponent() {
        return DaggerDemoComponent.builder().build();
    }

    public DemoComponent component() {
        return demoComponent;
    }

}
