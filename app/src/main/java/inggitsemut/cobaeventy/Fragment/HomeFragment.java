package inggitsemut.cobaeventy.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import inggitsemut.cobaeventy.Adapter.RecyclerViewBannerAdapter;
import inggitsemut.cobaeventy.R;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "HomeFragment";

    // vars
    private ArrayList<String> mImageUrls = new ArrayList<>();

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerViewBanner = rootView.findViewById(R.id.rvBannerHome);
        recyclerViewBanner.setLayoutManager(layoutManager);
        RecyclerViewBannerAdapter adapter = new RecyclerViewBannerAdapter(getActivity(), mImageUrls);
        recyclerViewBanner.setAdapter(adapter);

        getImages();
        return rootView;
    }




    @Override
    public void onClick(View v) {
    }

    public void getImages(){
        mImageUrls.add("https://jadwalevent.web.id/wp-content/uploads/2018/06/Indonesia-International-Book-Fair-2018.jpg");
        mImageUrls.add("https://jadwalevent.web.id/wp-content/uploads/2015/09/Jakarta-Culinary-Passport-%E2%80%9CAsian-Adventure%E2%80%9D-2015.jpg");
        mImageUrls.add("https://s3-ap-southeast-1.amazonaws.com/loket-production-sg/images/banner/20190709103135_5d240a9792416.jpg");
//        mImageUrls.add("https://www.indonesia.travel/content/dam/indtravelrevamp/en/news-events/news/wonderful-indonesia-festival-in-bangkok-legends-cultural-shows-and-scrumptious-food/Article-1.jpg");
    }

}
