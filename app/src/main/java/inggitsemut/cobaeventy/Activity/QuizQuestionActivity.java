package inggitsemut.cobaeventy.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;

import inggitsemut.cobaeventy.Animation.ProgressBarAnimation;
import inggitsemut.cobaeventy.R;

public class QuizQuestionActivity extends AppCompatActivity {

    TextView tvQuizName, tvTime;
    RoundCornerProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);

        // receive data
        Intent intentDetail = getIntent();
        String quizName = intentDetail.getExtras().getString("QuizName");
        tvQuizName = findViewById(R.id.quiz_name);

        tvQuizName.setText(quizName);

        // progress bar
        progressBar = findViewById(R.id.progress_bar);
        tvTime = findViewById(R.id.tv_time);

        progressBar.setMax(150);
        progressBar.setRotation(180);
        progressBar.setProgress(150);

        progressAnimation();
    }

    public void progressAnimation(){
        ProgressBarAnimation anim = new ProgressBarAnimation(this, progressBar, tvTime, 150f, 0f);
        anim.setDuration(15000);
        anim.setInterpolator(new LinearInterpolator());
        progressBar.setAnimation(anim);
    }
}
