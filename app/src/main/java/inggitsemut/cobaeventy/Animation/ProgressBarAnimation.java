package inggitsemut.cobaeventy.Animation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;

public class ProgressBarAnimation extends Animation {

    private Context context;
    private RoundCornerProgressBar progressBar;
    private TextView tvTime;
    private float from, to;

    public ProgressBarAnimation(Context context, RoundCornerProgressBar progressBar, TextView tvTime, float from, float to) {
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

        switch ((int)value){
            case 150:
                tvTime.setText((int)value/10+"s");
                break;
            case 140:
                tvTime.setText((int)value/10+"s");
                break;
            case 130:
                tvTime.setText((int)value/10+"s");
                break;
            case 120:
                tvTime.setText((int)value/10+"s");
                break;
            case 110:
                tvTime.setText((int)value/10+"s");
                break;
            case 100:
                tvTime.setText((int)value/10+"s");
                break;
            case 90:
                tvTime.setText((int)value/10+"s");
                break;
            case 80:
                tvTime.setText((int)value/10+"s");
                break;
            case 70:
                tvTime.setText((int)value/10+"s");
                break;
            case 60:
                tvTime.setText((int)value/10+"s");
                break;
            case 50:
                tvTime.setText((int)value/10+"s");
                break;
            case 40:
                tvTime.setText((int)value/10+"s");
                break;
            case 30:
                tvTime.setText((int)value/10+"s");
                break;
            case 20:
                tvTime.setText((int)value/10+"s");
                break;
            case 10:
                tvTime.setText((int)value/10+"s");
                break;
        }
        if (value == to){
            tvTime.setText((int)value+"s");
            Toast.makeText(context, "Waktumu habis!", Toast.LENGTH_SHORT).show();
        }
    }
}
