package inggitsemut.cobaeventy.Activity;

import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import inggitsemut.cobaeventy.Adapter.BannerHomeViewPagerAdapter;
import inggitsemut.cobaeventy.Adapter.RecyclerViewMenuAdapter;
import inggitsemut.cobaeventy.Models.BannerHome;
import inggitsemut.cobaeventy.Models.Menu;
import inggitsemut.cobaeventy.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    // banner
    private ViewPager viewPagerBannerHome;
    BannerHomeViewPagerAdapter bannerHomeViewPagerAdapter;
    TabLayout tabLayoutIndicator;
    int position = 0;

    // timer pada banner
    private Timer timer;
    private int current_position = 0;

    List<Menu> listMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // banner
        tabLayoutIndicator = findViewById(R.id.tab_indicator_banner_home);

        final List<BannerHome> listBanner = new ArrayList<>();
        listBanner.add(new BannerHome(R.drawable.a));
        listBanner.add(new BannerHome(R.drawable.b));
        listBanner.add(new BannerHome(R.drawable.c));

        // setup viewpager
        viewPagerBannerHome = findViewById(R.id.viewPagerBannerHome);
        bannerHomeViewPagerAdapter  = new BannerHomeViewPagerAdapter(this, listBanner);
        viewPagerBannerHome.setAdapter(bannerHomeViewPagerAdapter);

        // setup tab layout with view pager
        tabLayoutIndicator.setupWithViewPager(viewPagerBannerHome);


        // MENU GRID
        listMenu = new ArrayList<>();
        listMenu.add(new Menu("MY QR", R.drawable.ic_action_barcode_2));
        listMenu.add(new Menu("AGENDA", R.drawable.ic_action_barcode_2));
        listMenu.add(new Menu("GALLERY", R.drawable.ic_action_barcode_2));
        listMenu.add(new Menu("SLIDES", R.drawable.ic_action_barcode_2));
        listMenu.add(new Menu("MAPS", R.drawable.ic_action_barcode_2));
        listMenu.add(new Menu("MEMBER", R.drawable.ic_action_barcode_2));
        listMenu.add(new Menu("SURVEY", R.drawable.ic_action_barcode_2));
        listMenu.add(new Menu("QUIZ", R.drawable.ic_action_barcode_2));
        listMenu.add(new Menu("FEEDBACK", R.drawable.ic_action_barcode_2));
        listMenu.add(new Menu("QnA", R.drawable.ic_action_barcode_2));
        listMenu.add(new Menu("SOUVENIR", R.drawable.ic_action_barcode_2));
        listMenu.add(new Menu("HELP", R.drawable.ic_action_barcode_2));
        listMenu.add(new Menu("ABOUT", R.drawable.ic_action_barcode_2));

        RecyclerView myrv = findViewById(R.id.id_recycler_view);
        RecyclerViewMenuAdapter myAdapter = new RecyclerViewMenuAdapter(this, listMenu);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);

        // slide show pada banner
        createSlideShow();
    }

    private void createSlideShow(){
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (current_position == listMenu.size()){
                    current_position = 0;
                }

                viewPagerBannerHome.setCurrentItem(current_position++,true);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 500, 3000);

    }

    @Override
    public void onClick(View v) {

    }
}
