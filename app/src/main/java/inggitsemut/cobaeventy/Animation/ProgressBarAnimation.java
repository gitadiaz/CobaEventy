package inggitsemut.cobaeventy.Animation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProgressBarAnimation extends Animation {

    private Context context;
    private ProgressBar progressBar;
    private TextView tvTime;
    private float from, to;

    public ProgressBarAnimation(Context context, ProgressBar progressBar, TextView tvTime, float from, float to) {
        this.context = context;
        this.progressBar = progressBar;
        this.tvTime = tvTime;
        this.from = from;
        this.to = to;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float value = from + (to - from) * interpolatedTime;
        progressBar.setProgress((int)value);
        tvTime.setText((int)value+" %");

        if (value == to){
            Toast.makeText(context, "Waktumu habis!", Toast.LENGTH_SHORT).show();
        }
    }
}
