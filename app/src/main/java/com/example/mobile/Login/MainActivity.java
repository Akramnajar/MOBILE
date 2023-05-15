package com.example.mobile.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobile.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    ImageView googleBtn;
    ImageView fbbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username = (TextView) findViewById(R.id.login_email);
        TextView password = (TextView) findViewById(R.id.login_password);
        TextView SignUp = (TextView) findViewById(R.id.signup);
        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.login_button);

        //admin and admin


        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigatetoSignup();
            }
        });





        loginbtn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    //correct

                        navigateToSecondActivity();



                    Toast.makeText(MainActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, "LOGIN FAIL", Toast.LENGTH_SHORT).show();

                    //false
                }

            }

        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000){
            Task<GoogleSignInAccount> task= GoogleSignIn.getSignedInAccountFromIntent(data);

    }}
        void navigateToSecondActivity(){

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.right,R.anim.out_left);


        }
        void navigatetoSignup(){
            Intent intent = new Intent(MainActivity.this, SignUp.class);
            startActivity(intent);
            overridePendingTransition(R.anim.right,R.anim.out_left);

        }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.right,R.anim.out_left);
    }
}