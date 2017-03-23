package css.demo.espressodaggertesting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import css.demo.espressodaggertesting.dagger.DaggerMainActivityComponent;
import css.demo.espressodaggertesting.dagger.MainActivityPresenterModule;
import css.demo.espressodaggertesting.data.User;

public class MainActivity extends AppCompatActivity implements MainMVP.View {

    private static final String TAG = "MAIN-ACTIVITY";
    public static final String KEY_MILLIS = "millis";

    TextView tvName;
    ImageView ivAvatar;

    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = (TextView) findViewById(R.id.name);
        ivAvatar = (ImageView) findViewById(R.id.iv_avatar);

        DaggerMainActivityComponent.builder()
                .mainActivityPresenterModule(new MainActivityPresenterModule(this))
                .mainComponent(((MyApplication) getApplication()).component())
                .build()
                .inject(this);

        presenter.loadData();

    }

    @Override
    public void showData(User user) {
        tvName.setText(user.login);

        Picasso.with(this)
                .load(user.avatar_url)
                .fit()
                .centerCrop()
                .into(ivAvatar);
    }

    @Override
    public void showError(String errorResponse) {
        Toast.makeText(MainActivity.this, errorResponse, Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unSubscribe();
    }

}
