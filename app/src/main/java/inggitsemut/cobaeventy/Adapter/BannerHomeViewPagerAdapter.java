package inggitsemut.cobaeventy.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import inggitsemut.cobaeventy.Models.BannerHome;
import inggitsemut.cobaeventy.R;

public class BannerHomeViewPagerAdapter extends PagerAdapter {

    Context mContext;
    List<BannerHome> mListBanner;

    public BannerHomeViewPagerAdapter(Context mContext, List<BannerHome> mListBanner) {
        this.mContext = mContext;
        this.mListBanner = mListBanner;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater =(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutBanner = inflater.inflate(R.layout.layout_banner_home, null);

        ImageView imgBanner = layoutBanner.findViewById(R.id.img_banner_home);

        imgBanner.setImageResource(mListBanner.get(position).getImgHome());
        container.addView(layoutBanner);

        return layoutBanner;    }

    @Override
    public int getCount() {
        return mListBanner.size();
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
