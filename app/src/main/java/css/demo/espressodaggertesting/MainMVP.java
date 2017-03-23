package css.demo.espressodaggertesting;

import css.demo.espressodaggertesting.data.User;

/**
 * Contract interface for {@link MainActivity}
 */

public interface MainMVP {

    interface View {

        void showData(User user);

        void showError(String errorResponse);

    }

    interface Presenter {

        void loadData();

    }

}
