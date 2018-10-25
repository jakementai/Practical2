package practical.jakementai.practical2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String MESSAGE_TAG = "practical.jakementai.practical2.MESSAGE_TAG";
    public static final int REPLY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        EditText editTextMessage = findViewById(R.id.textEnterSendMessage);
        if(TextUtils.isEmpty(editTextMessage.getText())){
            editTextMessage.setError(getString(R.string.error_message));
            return;
        }

        String stringMsg = editTextMessage.getText().toString();
        //Use intent to pass data to next activity
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(MESSAGE_TAG, stringMsg);
        startActivityForResult(intent, REPLY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REPLY_REQUEST_CODE && resultCode == RESULT_OK){
            TextView textView = findViewById(R.id.textRepliedMessage);
            //TODO: Obtain data from intent
            String replyMsg = data.getStringExtra(SecondActivity.REPLY_TAG);
            textView.setText(replyMsg);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Main", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Main", "onResume");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Main", "onDestroy");

    }
}
