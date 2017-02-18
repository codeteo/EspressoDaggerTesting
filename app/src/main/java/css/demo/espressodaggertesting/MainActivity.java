package css.demo.espressodaggertesting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MAIN-ACTIVITY";
    public static final String KEY_MILLIS = "millis";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView todayView = (TextView) findViewById(R.id.date);

        ((MyApplication) getApplication()).component().inject(this);

    }
}
