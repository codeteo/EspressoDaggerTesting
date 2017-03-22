package css.demo.espressodaggertesting;

import css.demo.espressodaggertesting.data.User;

/**
 * Contract interface for {@link MainActivity}
 */

public interface MainMVP {

    interface View {

        void showData(User user);

    }

    interface Presenter {

        void loadData();

    }

}
