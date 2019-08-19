package inggitsemut.cobaeventy.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import inggitsemut.cobaeventy.Adapter.IntroViewPagerAdapter;
import inggitsemut.cobaeventy.Models.ScreenItem;
import inggitsemut.cobaeventy.R;

public class IntroActivity extends AppCompatActivity {

    private ViewPager viewPagerIntro;
    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabLayoutIndicator;
    Button btnNext;
    int position = 0;
    Button btnGetStarted;
    Animation btnAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //cek udah pernah buka aplikasinya atau belum untuk nampilin inro slider
        if (restorePrefData()){
            Intent intentMyActivity = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intentMyActivity);
            finish();
        }

        setContentView(R.layout.activity_intro);

        btnNext = findViewById(R.id.btn_next);
        tabLayoutIndicator = findViewById(R.id.tab_indicator_intro);
        btnGetStarted = findViewById(R.id.btn_get_started);
        btnAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button_animation);

        // fill list screen

//        Service service = getClient().create(Service.class);
//
//        final Call<ScreenItem> callIntroSlider = service.getIntroSlider();
//
//        callIntroSlider.enqueue(new Callback<ScreenItem>() {
//            @Override
//            public void onResponse(Call<ScreenItem> call, Response<ScreenItem> response) {
//                final List<ScreenItem> mList = new ArrayList<>();
//                for (i=0; i<response.body(); i++){
//                    mList.add(new ScreenItem(response.body().getTitle(), response.body().getDescription(), R.drawable.scan));
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<ScreenItem> call, Throwable t) {
//                Toast.makeText(IntroActivity.this, "gagal", Toast.LENGTH_LONG).show();
//            }
//
//
//        });
        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Scan", "Lorem ipsum dolor sit amet, eu nihil prompta vix, ne tacimates imperdiet vel, eu vis simul veniam regione. Postulant efficiendi sed at, eius liber bonorum id quo, mei ad noluisse patrioque. ", "https://images.genius.com/5b8ea872faf17e09914610774e46dbad.1000x1000x1.jpg"));
        mList.add(new ScreenItem("Search", "Lorem ipsum dolor sit amet, eu nihil prompta vix, ne tacimates imperdiet vel, eu vis simul veniam regione. Postulant efficiendi sed at, eius liber bonorum id quo, mei ad noluisse patrioque.", "https://images.genius.com/5b8ea872faf17e09914610774e46dbad.1000x1000x1.jpg"));
        mList.add(new ScreenItem("Navigate", "Lorem ipsum dolor sit amet, eu nihil prompta vix, ne tacimates imperdiet vel, eu vis simul veniam regione. Postulant efficiendi sed at, eius liber bonorum id quo, mei ad noluisse patrioque.", "https://images.genius.com/5b8ea872faf17e09914610774e46dbad.1000x1000x1.jpg"));

        // setup viewpager
        viewPagerIntro = findViewById(R.id.viewPagerIntroSlider);
        introViewPagerAdapter  = new IntroViewPagerAdapter(this, mList);
        viewPagerIntro.setAdapter(introViewPagerAdapter);

        // setup tab layout with view pager
        tabLayoutIndicator.setupWithViewPager(viewPagerIntro);

        // btn next set on click listener
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                position = viewPagerIntro.getCurrentItem();
                if (position < mList.size()){
                    position++;
                    viewPagerIntro.setCurrentItem(position);
                }

                if (position == mList.size()-1){
                    loadLastScreen();
                }
            }
        });

        // tab layout add change listener
        tabLayoutIndicator.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == mList.size()-1){
                    loadLastScreen();
                }
                else if (tab.getPosition() != mList.size()-1){
                    reloadScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // btn get started set on click listener
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMyActivity = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intentMyActivity);

                // buat user ga akses intro lagi kalo udah pernah buka
                // pake shared pref
                savePrefsData();
                finish();


            }
        });

    }

    private boolean restorePrefData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        Boolean isIntroOpenedBefore = pref.getBoolean("isIntroOpened", false);
        return isIntroOpenedBefore;

    }

    private void savePrefsData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpened", true);
        editor.commit();
    }

    private void loadLastScreen(){
        btnGetStarted.setVisibility(View.VISIBLE);
        tabLayoutIndicator.setVisibility(View.VISIBLE);
        btnNext.setVisibility(View.INVISIBLE);

        // button animation
        btnGetStarted.setAnimation(btnAnimation);

    }

    private void reloadScreen(){
        btnGetStarted.setVisibility(View.INVISIBLE);
        tabLayoutIndicator.setVisibility(View.VISIBLE);
        btnNext.setVisibility(View.VISIBLE);
    }
}
