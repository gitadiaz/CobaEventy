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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import inggitsemut.cobaeventy.Adapter.IntroViewPagerAdapter;
import inggitsemut.cobaeventy.Api.ConfigUtils;
import inggitsemut.cobaeventy.Api.Service;
import inggitsemut.cobaeventy.Models.ScreenItem;
import inggitsemut.cobaeventy.Models.ScreenItemList;
import inggitsemut.cobaeventy.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        // setup viewpager
        viewPagerIntro = findViewById(R.id.viewPagerIntroSlider);

        // fill list screen
        Service service = ConfigUtils.getClient().create(Service.class);

        final Call<ScreenItemList> callIntroSlider = service.getIntroSlider();

        callIntroSlider.enqueue(new Callback<ScreenItemList>() {
            @Override
            public void onResponse(Call<ScreenItemList> call, Response<ScreenItemList> response) {
//                final List<ScreenItem> mList = new ArrayList<>();
//                for (i=0; i<response.body(); i++){
//                    mList.add(new ScreenItem(response.body().getTitle(), response.body().getDescription(), R.drawable.scan));

                //getting list of heroes
                final ArrayList<ScreenItem> screenItems = response.body().getScreenItemList();

                // setup viewpager
                introViewPagerAdapter  = new IntroViewPagerAdapter(getApplicationContext(), screenItems);
                viewPagerIntro.setAdapter(introViewPagerAdapter);

                // setup tab layout with view pager
                tabLayoutIndicator.setupWithViewPager(viewPagerIntro);

                // btn next set on click listener
                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        position = viewPagerIntro.getCurrentItem();
                        if (position < screenItems.size()){
                            position++;
                            viewPagerIntro.setCurrentItem(position);
                        }

                        if (position == screenItems.size()-1){
                            loadLastScreen();
                        }
                    }
                });

                // tab layout add change listener
                tabLayoutIndicator.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        if (tab.getPosition() == screenItems.size()-1){
                            loadLastScreen();
                        }
                        else if (tab.getPosition() != screenItems.size()-1){
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
                }

            @Override
            public void onFailure(Call<ScreenItemList> call, Throwable t) {
                Toast.makeText(IntroActivity.this, "gagal", Toast.LENGTH_LONG).show();

            }

        });
//        final List<ScreenItem> mList = new ArrayList<>();
//        mList.add(new ScreenItem("Scan", "Lorem ipsum dolor sit amet, eu nihil prompta vix, ne tacimates imperdiet vel, eu vis simul veniam regione. Postulant efficiendi sed at, eius liber bonorum id quo, mei ad noluisse patrioque. ", "https://images.genius.com/5b8ea872faf17e09914610774e46dbad.1000x1000x1.jpg"));
//        mList.add(new ScreenItem("Search", "Lorem ipsum dolor sit amet, eu nihil prompta vix, ne tacimates imperdiet vel, eu vis simul veniam regione. Postulant efficiendi sed at, eius liber bonorum id quo, mei ad noluisse patrioque.", "https://images.genius.com/5b8ea872faf17e09914610774e46dbad.1000x1000x1.jpg"));
//        mList.add(new ScreenItem("Navigate", "Lorem ipsum dolor sit amet, eu nihil prompta vix, ne tacimates imperdiet vel, eu vis simul veniam regione. Postulant efficiendi sed at, eius liber bonorum id quo, mei ad noluisse patrioque.", "https://images.genius.com/5b8ea872faf17e09914610774e46dbad.1000x1000x1.jpg"));





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
