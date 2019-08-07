package inggitsemut.cobaeventy.Activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import inggitsemut.cobaeventy.Fragment.EventFragment;
import inggitsemut.cobaeventy.Fragment.HomeFragment;
import inggitsemut.cobaeventy.Fragment.InboxFragment;
import inggitsemut.cobaeventy.Fragment.MyBookingFragment;
import inggitsemut.cobaeventy.Fragment.ProfileFragment;
import inggitsemut.cobaeventy.R;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout fragmentContainer;

    private HomeFragment homeFragment;
    private EventFragment eventFragment;
    private MyBookingFragment myBookingFragment;
    private InboxFragment inboxFragment;
    private ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        fragmentContainer = findViewById(R.id.fragment_container);

        homeFragment = new HomeFragment();
        eventFragment = new EventFragment();
        myBookingFragment = new MyBookingFragment();
        inboxFragment = new InboxFragment();
        profileFragment = new ProfileFragment();

        FragmentTransaction HomeFragmentTransaction = getSupportFragmentManager().beginTransaction();
        HomeFragmentTransaction.replace(R.id.fragment_container, homeFragment);
        HomeFragmentTransaction.commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        createFragment(homeFragment);
                        return true;

                    case R.id.event:
                        createFragment(eventFragment);
                        return true;

                    case R.id.myBooking:
                        createFragment(myBookingFragment);
                        return true;

                    case R.id.inbox:
                        createFragment(inboxFragment);
                        return true;

                    case R.id.profile:
                        createFragment(profileFragment);
                        return true;
                }
                return false;
            }

            private void createFragment(Fragment fragment) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();

            }
        });

    }
}
