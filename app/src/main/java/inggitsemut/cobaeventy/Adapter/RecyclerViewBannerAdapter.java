package inggitsemut.cobaeventy.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import inggitsemut.cobaeventy.R;

public class RecyclerViewBannerAdapter extends RecyclerView.Adapter<RecyclerViewBannerAdapter.MyViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    // vars
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private Context mContext;

    public RecyclerViewBannerAdapter(Context mContext, ArrayList<String> imageUrls) {
        this.mImageUrls = imageUrls;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_banner_home, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Glide.with(mContext)
                .asBitmap()
                .load(mImageUrls.get(position))
                .into(holder.imgBannerHome);

        holder.imgBannerHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, mImageUrls.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imgBannerHome;

        public MyViewHolder(View itemView) {
            super(itemView);

            imgBannerHome = itemView.findViewById(R.id.img_banner_home);
        }
    }




}
