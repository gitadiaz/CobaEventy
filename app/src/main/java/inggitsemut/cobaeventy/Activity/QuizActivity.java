package inggitsemut.cobaeventy.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import inggitsemut.cobaeventy.Adapter.QuizListAdapter;
import inggitsemut.cobaeventy.Model.Quiz;
import inggitsemut.cobaeventy.Model.QuizData;
import inggitsemut.cobaeventy.R;

public class QuizActivity extends AppCompatActivity {
    private RecyclerView rvQuiz;
    private ArrayList<Quiz> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        rvQuiz = findViewById(R.id.rv_list_quiz);
        rvQuiz.setHasFixedSize(true);

        list.addAll(QuizData.getQuizListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvQuiz.setLayoutManager(new LinearLayoutManager(this));
        QuizListAdapter quizListAdapter = new QuizListAdapter(list);
        rvQuiz.setAdapter(quizListAdapter);
    }
}
