package inggitsemut.cobaeventy;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toolbar;

public class MyBookingActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;
    private Toolbar supportActionBar;

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_booking);

        toolbar = findViewById(R.id.toolbarMyBooking);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tabLayoutMyBooking);
        viewPager = findViewById(R.id.viewPagerMyBooking);
        ViewPagerMyBookingAdapter adapter = new ViewPagerMyBookingAdapter(getSupportFragmentManager());
        // Adding Fragments
        adapter.AddFragment(new FragmentUnpaidBooking(), "Unpaid");
        adapter.AddFragment(new FragmentPaidBooking(), "Paid");
        adapter.AddFragment(new FragmentCancelledBooking(), "Cancel");
        // Adapter setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}
