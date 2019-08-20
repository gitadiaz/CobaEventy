package inggitsemut.cobaeventy.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import inggitsemut.cobaeventy.Model.ScreenItem;
import inggitsemut.cobaeventy.R;

public class IntroViewPagerAdapter extends PagerAdapter {

    Context mContext;
    List<ScreenItem> mListScreen;

    public IntroViewPagerAdapter(Context mContext, List<ScreenItem> mListScreen) {
        this.mContext = mContext;
        this.mListScreen = mListScreen;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater =(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen = inflater.inflate(R.layout.layout_screen, null);

        ImageView imgSlide = layoutScreen.findViewById(R.id.img_screen_intro);
        TextView title = layoutScreen.findViewById(R.id.txt_title_intro);
        TextView description = layoutScreen.findViewById(R.id.txt_description_intro);

        title.setText(mListScreen.get(position).getSplash_title());
        description.setText(mListScreen.get(position).getSplash_desc());

//        imgSlide.setImageResource(mListScreen.get(position).getImgIntro());

        Glide.with(mContext)
                .load(mListScreen.get(position).getSplash_image())
                .apply(new RequestOptions())
                .into(imgSlide);

        container.addView(layoutScreen);

        return layoutScreen;

    }

    @Override
    public int getCount() {
        return mListScreen.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
