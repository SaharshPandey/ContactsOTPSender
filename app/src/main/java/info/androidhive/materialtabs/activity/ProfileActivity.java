package info.androidhive.materialtabs.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageButton;
import android.widget.TextView;

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
        String name = getIntent().getExtras().getString("name");
        String contact = getIntent().getExtras().getString("contact");
        String address = getIntent().getExtras().getString("address");

        UserImage = findViewById(R.id.user_image);
        UserName = findViewById(R.id.user_name);
        UserContact = findViewById(R.id.user_contact);
        UserAddress = findViewById(R.id.user_address);
        SendMessage = findViewById(R.id.send_message);

        UserImage.setImageResource(R.drawable.profile);
        UserName.setText(name);
        UserContact.setText(contact);
        UserAddress.setText(address);



    }
}
