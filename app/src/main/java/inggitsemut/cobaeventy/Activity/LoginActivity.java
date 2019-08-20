package inggitsemut.cobaeventy.Activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import inggitsemut.cobaeventy.R;

public class LoginActivity extends AppCompatActivity {
    private Button btnSignIn;
    private TextView btnSignUp, btnForgotPassword;
    private LoginButton btnLoginFacebook;
    private EditText etUsername, etPassword;

    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnSignIn = findViewById(R.id.btn_sign_in);
        btnSignUp = findViewById(R.id.btn_sign_up);
//        btnLoginFacebook = findViewById(R.id.login_button_facebook);
        btnForgotPassword = findViewById(R.id.btn_forgot_password);

        // api facebook
//        callbackManager = CallbackManager.Factory.create();
//        btnLoginFacebook.setReadPermissions(Arrays.asList("email", "public_profile"));
//
//        btnLoginFacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
////                loaduserProfile(AccessToken.getCurrentAccessToken());
//                Intent intentLogin = new Intent(LoginActivity.this, HomeActivity.class);
//                startActivity(intentLogin);
//                finish();
//            }
//
//            @Override
//            public void onCancel() {
//
//            }
//
//            @Override
//            public void onError(FacebookException error) {
//
//            }
//        });


        // klik button sign in
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intentHome);
                Toast.makeText(LoginActivity.this, "Sign in Success", Toast.LENGTH_SHORT).show();
            }
        });

        // klik button sign up
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSignUp = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intentSignUp);
            }
        });

        // klik button forgot password
        btnForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentForgotPassword = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intentForgotPassword);
            }
        });
    }

    void showToast(String msg){
        Toast.makeText(this, ""+msg, Toast.LENGTH_LONG).show();
    }

//    // facebook api
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        callbackManager.onActivityResult(requestCode, resultCode, data);
//        super.onActivityResult(requestCode, resultCode, data);
//    }
//
//    AccessTokenTracker tokenTracke = new AccessTokenTracker() {
//        @Override
//        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
//            if (currentAccessToken==null){
//                Toast.makeText(LoginActivity.this, "User log out", Toast.LENGTH_SHORT).show();
//            }
//            else{
//                loaduserProfile(currentAccessToken);
//            }
//        }
//    };
//
//    private void loaduserProfile(AccessToken newAccessToken){
//        GraphRequest request = GraphRequest.newMeRequest(newAccessToken, new GraphRequest.GraphJSONObjectCallback() {
//            @Override
//            public void onCompleted(JSONObject object, GraphResponse response) {
//                try {
//                    String first_name = object.getString("first_nanme");
//                    String last_name = object.getString("last_name");
//                    String email = object.getString("email");
//                    String id = object.getString("id");
//                    String image_url = "https://graph.facebook.com/"+id+"/picture?type=normal";
//
//                    Intent intentLogin = new Intent(LoginActivity.this, HomeActivity.class);
//                    startActivity(intentLogin);
//
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        Bundle parameters = new Bundle();
//    }


}
