package inggitsemut.cobaeventy.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import inggitsemut.cobaeventy.R;

public class LoginActivity extends AppCompatActivity {
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnSignIn = findViewById(R.id.btn_sign_in);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intentHome);
                Toast.makeText(LoginActivity.this, "Sign in Success", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
