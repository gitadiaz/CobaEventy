package inggitsemut.cobaeventy.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import inggitsemut.cobaeventy.R;

public class DetailsProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_profile);

        setTitle("Profile");
//        getSupportActionBar().setTitle("Profile");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
