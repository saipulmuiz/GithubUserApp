package id.muiz.githubuserapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_USER = "extra_user";
    private TextView tvName, tvUsername, tvCompany, tvLocation, tvRepository, tvFollower, tvFollowing;
    private CircleImageView imgAvatar;
    private ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvName = findViewById(R.id.nama);
        tvCompany = findViewById(R.id.tv_company);
        tvUsername = findViewById(R.id.tv_username);
        tvLocation = findViewById(R.id.tv_location);
        tvRepository = findViewById(R.id.jml_repository);
        tvFollower = findViewById(R.id.jml_followers);
        tvFollowing = findViewById(R.id.jml_following);
        imgAvatar = findViewById(R.id.img_foto_user_detail);

        users = getIntent().getParcelableArrayListExtra(EXTRA_USER);
        assert users != null;
        // tvName.setText(users);
        // tvUsername.setText(users.getUsername());
        // tvCompany.setText(users.getCompany());
        // tvLocation.setText(users.getLocation());
        // imgAvatar.setImageResource(users.getAvatar());
    }
}
