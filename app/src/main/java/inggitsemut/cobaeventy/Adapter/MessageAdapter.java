package inggitsemut.cobaeventy.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import inggitsemut.cobaeventy.Model.Message;
import inggitsemut.cobaeventy.R;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder>{
    private ArrayList<Message> data = new ArrayList<>();
    private Context mCtx;

    private OnMessageListener mOnMessageListener;

    public MessageAdapter(ArrayList<Message> data, Context mCtx, OnMessageListener onMessageListener) {
        this.data = data;
        this.mCtx = mCtx;
        this.mOnMessageListener = onMessageListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_message, viewGroup, false);
        return new ViewHolder(view, mOnMessageListener);
    }

    @Override
    public void onBindViewHolder(MessageAdapter.ViewHolder holder, int position) {

        final Message message = data.get(position);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        OnMessageListener onMessageListener;

        public ViewHolder(View itemView, OnMessageListener onMessageListener) {
            super(itemView);

            this.onMessageListener = onMessageListener;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onMessageListener.onMessageClick(getAdapterPosition());
        }
    }

    public interface OnMessageListener{
        void onMessageClick(int position);
    }
}
