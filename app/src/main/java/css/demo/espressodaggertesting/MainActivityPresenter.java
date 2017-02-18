package css.demo.espressodaggertesting;

import javax.inject.Inject;

/**
 * Created by css on 2/18/17.
 */

public class MainActivityPresenter implements MainMVP.Presenter {

    MainMVP.View view;

    @Inject
    public MainActivityPresenter(MainMVP.View view) {
        this.view = view;
    }

    @Override
    public void getData() {

    }
}
