package inggitsemut.cobaeventy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import inggitsemut.cobaeventy.Activity.DetailsProfileActivity;
import inggitsemut.cobaeventy.Models.Menu;
import inggitsemut.cobaeventy.Activity.MyBookingActivity;
import inggitsemut.cobaeventy.Activity.MyQRActivity;
import inggitsemut.cobaeventy.R;

public class RecyclerViewMenuAdapter extends RecyclerView.Adapter<RecyclerViewMenuAdapter.MyViewHolder> {

    private Context mContext;
    private List<Menu> mData;

    public RecyclerViewMenuAdapter(Context mContext, List<Menu> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item_menu, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.tv_menu_title.setText(mData.get(position).getTitle());
        holder.img_menu.setImageResource(mData.get(position).getImage());

        // Set Click on Listener
        holder.cardViewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position==0){
                    Intent intentQR = new Intent(mContext, MyQRActivity.class);
                    mContext.startActivity(intentQR);
                }
                else if (position==1){
                    // open activity agenda
                    // pake activity details dulu
                    Intent intentAgenda = new Intent(mContext, DetailsProfileActivity.class);
                    mContext.startActivity(intentAgenda);
                }else if (position==2){
                    // gallery
                    //open activity my Booking activity
                    Intent intentMyBooking = new Intent(mContext, MyBookingActivity.class);
                    mContext.startActivity(intentMyBooking);
                }else{
                    Intent intentAgenda = new Intent(mContext, DetailsProfileActivity.class);
                    mContext.startActivity(intentAgenda);
                }

                //dst

            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_menu_title;
        ImageView img_menu;
        CardView cardViewMenu;

        public MyViewHolder(View itemView){
            super(itemView);

            tv_menu_title = itemView.findViewById(R.id.id_menu_title);
            img_menu = itemView.findViewById(R.id.id_menu_img);
            cardViewMenu = itemView.findViewById(R.id.cardview_menu_id);
        }

    }

}
