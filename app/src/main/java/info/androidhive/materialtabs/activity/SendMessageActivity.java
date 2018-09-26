package info.androidhive.materialtabs.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import info.androidhive.materialtabs.R;


public class SendMessageActivity extends AppCompatActivity {

    private TextView Message;
    private Button SendMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        Message = findViewById(R.id.textfield);
        SendMessage = findViewById(R.id.message_button);

        Random random = new Random(6);
        int otp = random.nextInt();

        Message.setText(" “Hi.Your  OTP  is: "+String.valueOf(otp));
        SendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

    }
}
