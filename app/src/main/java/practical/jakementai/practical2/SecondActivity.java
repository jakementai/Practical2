package practical.jakementai.practical2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String REPLY_TAG = "practical.jakementai.practical2.REPLY_TAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent(); //Who stardle me?

        if (intent.hasExtra(MainActivity.MESSAGE_TAG)) {
            TextView sentMessage = findViewById(R.id.textSentMessage);
            String stringMsg = intent.getStringExtra(MainActivity.MESSAGE_TAG);
            sentMessage.setText(stringMsg);
        }

    }

    public void replyMessage(View view) {
        EditText editText = findViewById(R.id.textEnterReplyMessage);

        //Check for error
        if(TextUtils.isEmpty(editText.getText())){
            editText.setError(getString(R.string.error_message));
            return;
        }

        String stringReply = editText.getText().toString();
        Intent intent = new Intent().putExtra(REPLY_TAG, stringReply);

        setResult(RESULT_OK, intent);
        finish();

    }
}
