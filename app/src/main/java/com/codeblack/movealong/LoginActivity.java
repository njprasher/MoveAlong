package com.codeblack.movealong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.codeblack.movealong.Utilities.Utility;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;

    private EditText edtUserName;
    private EditText edtPassword;

    private TextView text_register;
    FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        Users u1 = new Users("raj@gmail.com" ,"123456");
        Users u2 = new Users("neeraj@gmail.com" ,"123456");
        Users u3 = new Users("uday@gmail.com" ,"123456");
        Users u4 = new Users("ujwal@gmail.com" ,"123456");
        Users u5 = new Users("vipul@gmail.com" ,"123");

        Users.userArray.add(u1);
        Users.userArray.add(u2);
        Users.userArray.add(u3);
        Users.userArray.add(u4);
        Users.userArray.add(u5);

        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                login();
            }
        });

        text_register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent mIntent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(mIntent);
                finish();
            }
        });

        mAuth = FirebaseAuth.getInstance();
        initView();

    }

    private void initView()
    {
        edtUserName = (EditText)findViewById(R.id.edtEmail);
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);

        text_register= (TextView)findViewById(R.id.link_signup);

    }


    private void login()
    {

        String userName = edtUserName.getText().toString();
        String password = edtPassword.getText().toString();

        int temp = 0;

        if(userName.isEmpty() || userName.trim().length() == 0)
        {
            Utility.utility_Toast(LoginActivity.this , "Enter Email ID");
            return;
        }else if (password.isEmpty() || password.trim().length() == 0){
            Utility.utility_Toast(LoginActivity.this , "Enter Password");
        }else{

                mAuth.signInWithEmailAndPassword(userName, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
//                                    Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Utility.utility_Toast(LoginActivity.this, "Auth");

                                    Intent mIntent = new Intent(LoginActivity.this, TabViewActivity.class);
                                    startActivity(mIntent);
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.
//                                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Utility.utility_Toast(LoginActivity.this, "Authentication failed.");
                                }

                                // ...
                            }
                        });

            }

        }

    }




