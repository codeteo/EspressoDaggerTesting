package css.demo.espressodaggertesting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;

import css.demo.espressodaggertesting.dagger.DaggerMainActivityComponent;
import css.demo.espressodaggertesting.dagger.MainActivityPresenterModule;

public class MainActivity extends AppCompatActivity implements MainMVP.View {

    private static final String TAG = "MAIN-ACTIVITY";
    public static final String KEY_MILLIS = "millis";

    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView todayView = (TextView) findViewById(R.id.date);

        DaggerMainActivityComponent.builder()
                .mainActivityPresenterModule(new MainActivityPresenterModule(this))
                .mainComponent(((MyApplication) getApplication()).component())
                .build()
                .inject(this);

        presenter.getData();


    }

    @Override
    public void showData() {

    }
}
