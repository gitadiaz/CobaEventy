package inggitsemut.cobaeventy.Adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import inggitsemut.cobaeventy.Activity.QuizQuestionActivity;
import inggitsemut.cobaeventy.Model.Quiz;
import inggitsemut.cobaeventy.R;

public class QuizListAdapter extends RecyclerView.Adapter<QuizListAdapter.ListViewHolder> {

    private ArrayList<Quiz> listQuiz;

    public QuizListAdapter(ArrayList<Quiz> listQuiz) {
        this.listQuiz = listQuiz;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_quiz, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final Quiz quiz = listQuiz.get(position);

        holder.quizName.setText(quiz.getQuizName());

        holder.layoutQuizList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentStartQuiz = new Intent(holder.itemView.getContext(), QuizQuestionActivity.class);

                // parsing data
                intentStartQuiz.putExtra("QuizName",quiz.getQuizName());

                holder.itemView.getContext().startActivity(intentStartQuiz);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listQuiz.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView quizName;
        LinearLayout layoutQuizList;


        public ListViewHolder (View itemView){
            super(itemView);

            quizName = itemView.findViewById(R.id.tv_quiz_name);
            layoutQuizList = itemView.findViewById(R.id.layout_listQuiz);
        }

    }
}
