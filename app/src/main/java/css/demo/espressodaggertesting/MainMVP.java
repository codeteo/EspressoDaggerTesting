package css.demo.espressodaggertesting;

/**
 * Contract interface for {@link MainActivity}
 */

public interface MainMVP {

    interface View {

        void showData();

    }

    interface Presenter {

        void getData();

    }

}
