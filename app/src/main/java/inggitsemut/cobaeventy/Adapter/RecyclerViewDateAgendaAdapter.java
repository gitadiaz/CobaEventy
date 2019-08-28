package inggitsemut.cobaeventy.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import inggitsemut.cobaeventy.Model.Agenda;
import inggitsemut.cobaeventy.Model.Menu;
import inggitsemut.cobaeventy.R;

public class RecyclerViewDateAgendaAdapter extends RecyclerView.Adapter<RecyclerViewDateAgendaAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<Agenda> mData;

    public RecyclerViewDateAgendaAdapter(Context mContext, ArrayList<Agenda> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public RecyclerViewDateAgendaAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.item_date_agenda, parent, false);
        return new RecyclerViewDateAgendaAdapter.MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final RecyclerViewDateAgendaAdapter.MyViewHolder holder, final int position) {
        holder.tvDate.setText(mData.get(position).getDate());
        holder.tvDay.setText(mData.get(position).getDay());

        holder.layoutDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, ""+ mData.get(position), Toast.LENGTH_SHORT).show();


            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvDate, tvDay;
        RelativeLayout layoutDate;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvDate = itemView.findViewById(R.id.tv_date);
            tvDay = itemView.findViewById(R.id.tv_day);
            layoutDate = itemView.findViewById(R.id.layout_date);
        }
    }
}
