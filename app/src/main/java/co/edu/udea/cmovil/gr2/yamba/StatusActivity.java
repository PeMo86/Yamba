package co.edu.udea.cmovil.gr2.yamba;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.thenewcircle.yamba.client.YambaClient;

public class StatusActivity extends Activity {

    private  static  final  String TAG = StatusActivity.class.getSimpleName();
    private Button mButtonTweet;
    private EditText mTextStatus;
    private TextView mTextCount;
    private int mDefaultColor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonTweet=(Button) findViewById(R.id.status_button_tweet);
        mTextStatus=(EditText) findViewById(R.id.status_text);
        mTextCount=(TextView) findViewById(R.id.status_text_count);

        mTextCount.setText(Integer.toString(140));
        mDefaultColor=mTextCount.getTextColors().getDefaultColor();

        mButtonTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String status=mTextStatus.getText().toString();
                PostTask postTask= new PostTask(TAG,StatusActivity.this);
                postTask.execute(status);
                Log.d(TAG, "onClicked");


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
