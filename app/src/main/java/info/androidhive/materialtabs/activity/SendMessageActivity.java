package info.androidhive.materialtabs.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.auth.AuthMethod;
import com.nexmo.client.auth.TokenAuthMethod;
import com.nexmo.client.sms.SmsClient;
import com.nexmo.client.sms.SmsSubmissionResult;
import com.nexmo.client.sms.messages.TextMessage;

import java.io.IOException;
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
        final NexmoClient client = new NexmoClient(auth);


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

                TextMessage exampleMessage = new TextMessage(
                        "Kisan Inc",
                        "918449681651",Message.getText().toString()
                );

                SmsSubmissionResult[] responses = new SmsSubmissionResult[0];
                try {
                    responses = client.getSmsClient().submitMessage(exampleMessage);
                }


                catch (IOException e) {
                    e.printStackTrace();
                } catch (NexmoClientException e) {
                    e.printStackTrace();
                }


                for (SmsSubmissionResult response : responses) {
                    System.out.println(response);
                }


            }
        });

    }
}
