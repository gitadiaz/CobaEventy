package inggitsemut.cobaeventy.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import inggitsemut.cobaeventy.Adapter.BannerAdapterPager;
import inggitsemut.cobaeventy.Adapter.RecyclerViewMenuAdapter;
import inggitsemut.cobaeventy.Models.Menu;
import inggitsemut.cobaeventy.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    // Details Profile
    Button btnDetailsProfile;

    // banner
    ViewPager viewPagerBanner;
    List<Integer> dataImage = new ArrayList<>();
    ImageView indicator1, indicator2, indicator3;

    // timer pada banner
    private Timer timer;
    private int current_position = 0;


    List<Menu> listMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Details Profile
        btnDetailsProfile = findViewById(R.id.btnDetailsProfile);
        btnDetailsProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDetailsProfile = new Intent(HomeActivity.this, DetailsProfileActivity.class);
                startActivity(intentDetailsProfile);

            }
        });

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
        RecyclerViewMenuAdapter myAdapter = new RecyclerViewMenuAdapter(this, listMenu );
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);

        // banner
        viewPagerBanner = findViewById(R.id.viewPagerBanner);
        dataImage.add(R.drawable.a);
        dataImage.add(R.drawable.b);
        dataImage.add(R.drawable.c);

        indicator1 = findViewById(R.id.indicator1);
        indicator2 = findViewById(R.id.indicator2);
        indicator3 = findViewById(R.id.indicator3);

        BannerAdapterPager bannerAdapterPager = new BannerAdapterPager(this, dataImage);
        viewPagerBanner.setAdapter(bannerAdapterPager);

        // ini buat bkin bulet2nya beda fokus
        viewPagerBanner.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i==0){
                    indicator1.setImageResource(R.drawable.circle_white);
                    indicator2.setImageResource(R.drawable.circle_green);
                    indicator3.setImageResource(R.drawable.circle_green);
                }
                else if (i==1){
                    indicator1.setImageResource(R.drawable.circle_green);
                    indicator2.setImageResource(R.drawable.circle_white);
                    indicator3.setImageResource(R.drawable.circle_green);
                }
                else if (i==2){
                    indicator1.setImageResource(R.drawable.circle_green);
                    indicator2.setImageResource(R.drawable.circle_green);
                    indicator3.setImageResource(R.drawable.circle_white);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        // slide show pada banner
        createSlideShow();
    }

    private void createSlideShow(){
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (current_position == dataImage.size()){
                    current_position = 0;
                }

                viewPagerBanner.setCurrentItem(current_position++,true);
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
