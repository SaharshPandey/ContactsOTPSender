package info.androidhive.materialtabs.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.json.JSONException;

import de.hdodenhof.circleimageview.CircleImageView;
import info.androidhive.materialtabs.R;

public class ProfileActivity extends AppCompatActivity {

    private TextView UserName,UserContact,UserAddress;
    private ImageButton SendMessage;
    private CircleImageView UserImage;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        final String name = getIntent().getExtras().getString("name");
        final String contact = getIntent().getExtras().getString("contact");
        final String address = getIntent().getExtras().getString("address");

        UserImage = findViewById(R.id.user_image);
        UserName = findViewById(R.id.user_name);
        UserContact = findViewById(R.id.user_contact);
        UserAddress = findViewById(R.id.user_address);
        SendMessage = findViewById(R.id.send_message);

        UserImage.setImageResource(R.drawable.profile);
        UserName.setText(name);
        UserContact.setText(contact);
        UserAddress.setText(address);


        SendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile = new Intent(ProfileActivity.this,SendMessageActivity.class);
                profile.putExtra("name",name);
                profile.putExtra("contact",contact);


                startActivity(profile);
            }
        });

    }
}
