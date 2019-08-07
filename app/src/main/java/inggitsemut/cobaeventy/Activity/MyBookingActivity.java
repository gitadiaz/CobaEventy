package inggitsemut.cobaeventy.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

import inggitsemut.cobaeventy.Adapter.ViewPagerMyBookingAdapter;
import inggitsemut.cobaeventy.Fragment.CancelledBookingFragment;
import inggitsemut.cobaeventy.Fragment.PaidBookingFragment;
import inggitsemut.cobaeventy.Fragment.UnpaidBookingFragment;
import inggitsemut.cobaeventy.R;

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
        adapter.AddFragment(new UnpaidBookingFragment(), "Unpaid");
        adapter.AddFragment(new PaidBookingFragment(), "Paid");
        adapter.AddFragment(new CancelledBookingFragment(), "Cancel");
        // Adapter setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}
