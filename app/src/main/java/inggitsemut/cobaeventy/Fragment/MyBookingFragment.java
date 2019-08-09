package inggitsemut.cobaeventy.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

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
        return rootView;
    }


    @Override
    public void onClick(View v) {
    }

}
