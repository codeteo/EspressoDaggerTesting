package css.demo.espressodaggertesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MAIN-ACTIVITY";

    @Inject
    Clock clock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApplication) getApplication()).component().inject(this);

        Log.i(TAG, "onCreate clock: " + clock.getNow());

    }
}
