package css.demo.espressodaggertesting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.joda.time.DateTime;

import javax.inject.Inject;

import static css.demo.espressodaggertesting.DateUtils.*;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MAIN-ACTIVITY";
    public static final String KEY_MILLIS = "millis";

    @Inject
    Clock clock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView todayView = (TextView) findViewById(R.id.date);

        ((MyApplication) getApplication()).component().inject(this);

        Log.i(TAG, "onCreate clock: " + clock.getNow());


        long millis = getIntent().getLongExtra(KEY_MILLIS, -1);
        DateTime dateTime = (millis > 0) ? new DateTime(millis) : clock.getNow();
        todayView.setText(format(dateTime));

    }
}
