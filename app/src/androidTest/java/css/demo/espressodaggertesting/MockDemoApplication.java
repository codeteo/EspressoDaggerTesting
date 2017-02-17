package css.demo.espressodaggertesting;

/**
 * Created by css on 2/17/17.
 */

public class MockDemoApplication extends MyApplication {

    @Override
    protected DemoComponent createComponent() {
        return DaggerMockDemoComponent.builder().build();
    }
}
