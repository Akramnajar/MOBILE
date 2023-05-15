package com.example.mobile.Login;

import static com.example.mobile.R.anim.right;
import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobile.R;
import com.google.android.material.button.MaterialButton;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        EditText Username = (EditText) findViewById(R.id.userid) ;
        EditText Email = (EditText) findViewById(R.id.Email) ;
        EditText Pass = (EditText) findViewById(R.id.Pass) ;
        EditText rPass = (EditText) findViewById(R.id.rPass) ;
        MaterialButton reghtn = (MaterialButton) findViewById(R.id.signup_button) ;

        TextView or = (TextView)findViewById(R.id.or);
        reghtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (Username.getText().length() == 0) {
                        Toast.makeText(SignUp.this, "Please enter a Username", Toast.LENGTH_SHORT).show();
                    } else if (Email.getText().length() == 0) {
                        Toast.makeText(SignUp.this, "Please enter an Email", Toast.LENGTH_SHORT).show();
                    } else if (Pass.getText().length() <= 8) {
                        Toast.makeText(SignUp.this, "Please enter a Strong Password", Toast.LENGTH_SHORT).show();
                    } else if (!Pass.getText().toString().equals(rPass.getText().toString())) {
                        Toast.makeText(SignUp.this, "password doesn't match", Toast.LENGTH_SHORT).show();
                    } else {
                        String username1 = Username.getText().toString();
                        Toast.makeText(SignUp.this, "Username is" + username1, Toast.LENGTH_SHORT).show();
                        navigateToSecondActivity();


                }

            }});

        or.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigatetologin();
                overridePendingTransition(R.anim.left,R.anim.out_right);
            }
        });
    }
    void navigatetologin() {


        Intent intent = new Intent(SignUp.this, MainActivity.class);
        startActivity(intent);
    }
    void navigateToSecondActivity(){
        finish();
        Intent intent = new Intent(SignUp.this, SecondActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.right,R.anim.out_left);

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.left,R.anim.out_right);
    }
}
