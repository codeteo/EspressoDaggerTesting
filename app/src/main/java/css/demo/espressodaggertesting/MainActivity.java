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

import static css.demo.espressodaggertesting.network.ErrorCode.CODE_401_UNAUTHORIZED;
import static css.demo.espressodaggertesting.network.ErrorCode.CODE_404_PAGE_NOT_FOUND;
import static css.demo.espressodaggertesting.network.ErrorCode.CODE_UNKNOWNHOST_EXCEPTION;

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

        tvName = (TextView) findViewById(R.id.tv_name);
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
        String toastResponse = null;
        switch (errorResponse) {
            case CODE_401_UNAUTHORIZED :
                toastResponse = getResources().getString(R.string.unauthorized_request);
                break;
            case CODE_404_PAGE_NOT_FOUND :
                toastResponse = getResources().getString(R.string.page_not_found);
                break;
            case CODE_UNKNOWNHOST_EXCEPTION :
                toastResponse = getResources().getString(R.string.unknown_host);
                break;
        }
        Toast.makeText(MainActivity.this, toastResponse, Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unSubscribe();
    }

}
