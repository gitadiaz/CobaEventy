package inggitsemut.cobaeventy.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import inggitsemut.cobaeventy.Adapter.ViewPagerMyBookingAdapter;
import inggitsemut.cobaeventy.R;

public class MyBookingFragment extends Fragment implements View.OnClickListener {

    android.support.v7.widget.Toolbar toolbar;
    private Toolbar supportActionBar;

    private TabLayout tabLayout;
    private ViewPager viewPager;

    public MyBookingFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_my_booking, container, false);

        toolbar = rootView.findViewById(R.id.toolbarMyBooking);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        tabLayout = rootView.findViewById(R.id.tabLayoutMyBooking);
        viewPager = rootView.findViewById(R.id.viewPagerMyBooking);
        ViewPagerMyBookingAdapter adapter = new ViewPagerMyBookingAdapter(getActivity().getSupportFragmentManager());
        // Adding Fragments
        adapter.AddFragment(new UnpaidBookingFragment(), "Unpaid");
        adapter.AddFragment(new PaidBookingFragment(), "Paid");
        adapter.AddFragment(new CancelledBookingFragment(), "Cancel");
        // Adapter setup
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        return rootView;

    }


    @Override
    public void onClick(View v) {
    }

}
