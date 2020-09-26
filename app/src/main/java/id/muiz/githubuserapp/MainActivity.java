package id.muiz.githubuserapp;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private UserAdapter adapter;
    private String[] dataName;
    private String[] dataUsername;
    private String[] dataCompany;
    private String[] dataLocation;
    private int[] dataRepository;
    private int[] dataFollower;
    private int[] dataFollowing;
    private TypedArray dataAvatar;
    private ArrayList<User> users;

    private boolean doubleBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_user);
        adapter = new UserAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent listClicked = new Intent(MainActivity.this, DetailActivity.class);
                listClicked.putExtra(DetailActivity.EXTRA_USER, users);
                startActivity(listClicked);
                Toast.makeText(MainActivity.this, users.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.name);
        dataUsername = getResources().getStringArray(R.array.username);
        dataCompany = getResources().getStringArray(R.array.company);
        dataLocation = getResources().getStringArray(R.array.location);
        dataRepository = getResources().getIntArray(R.array.repository);
        dataFollower = getResources().getIntArray(R.array.followers);
        dataFollowing = getResources().getIntArray(R.array.following);
        dataAvatar = getResources().obtainTypedArray(R.array.avatar);
    }

    private void addItem() {
        users = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            User user = new User();
            user.setAvatar(dataAvatar.getResourceId(i, -1));
            user.setName(dataName[i]);
            user.setUsername(dataUsername[i]);
            user.setCompany(dataCompany[i]);
            user.setLocation(dataLocation[i]);
            user.setRepository(dataRepository[i]);
            user.setFollower(dataFollower[i]);
            user.setFollowing(dataFollowing[i]);
            users.add(user);
        }

        adapter.setUserList(users);
    }

    @Override
    public void onBackPressed() {
        if (doubleBack) {
            super.onBackPressed();
            return;
        }

        Toast.makeText(this, "Tekan sekali lagi untuk keluar!", Toast.LENGTH_SHORT).show();

        doubleBack = true;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBack = false;
            }
        }, 2000);
    }
}
