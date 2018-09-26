package info.androidhive.materialtabs.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.auth.AuthMethod;
import com.nexmo.client.auth.TokenAuthMethod;
import com.nexmo.client.sms.SmsClient;
import com.nexmo.client.sms.messages.TextMessage;

import java.util.Random;

import info.androidhive.materialtabs.R;


public class SendMessageActivity extends AppCompatActivity {

    private TextView Message;
    private Button SendMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);



        final AuthMethod auth = new TokenAuthMethod("bb20f7cc", "3wJNtx7J6FfYbANN");
        NexmoClient client = new NexmoClient(auth);


        final String name = getIntent().getExtras().getString("name");
        final String contact = getIntent().getExtras().getString("contact");


        Message = findViewById(R.id.textfield);
        SendMessage = findViewById(R.id.message_button);

        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);

        Message.setText("Hi "+name+". Your  OTP  is: "+String.valueOf(otp));
        SendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SmsClient client = new NexmoClient(auth).getSmsClient();

                TextMessage exampleMessage = new TextMessage(
                        "Acme Inc",
                        "+918449681651",
                        "A text message sent using the Nexmo SMS API"
                );


            }
        });

    }
}
