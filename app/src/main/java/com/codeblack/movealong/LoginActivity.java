package com.codeblack.movealong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText edtUserName;
    private EditText edtPassword;

    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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

        initView();

        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                login();
            }
        });

    }

    private void initView()
    {
        edtUserName = (EditText)findViewById(R.id.edtEmail);
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);
    }


    private void login()
    {

        String userName = edtUserName.getText().toString();
        String password = edtPassword.getText().toString();

        int temp = 0;

        if(userName.isEmpty() || userName.trim().length() == 0)
        {
            edtUserName.setError("Enter Email ID");
            return;
        }else if (password.isEmpty() || password.trim().length() == 0){
            edtPassword.setError("Enter Password");
        }else{
            for( int i =0 ; i < Users.userArray.size() ; i++){
                if (Users.userArray.get(i).Email.equals(userName) && Users.userArray.get(i).Password.equals(password)){
                    Intent mIntent = new Intent(LoginActivity.this, HomeActivity.class);

                    startActivity(mIntent);
                    finish();
                }else{
                    temp = temp+1;
                }
            }

            if(temp == Users.userArray.size()){
                Toast.makeText(getApplicationContext(),"UserName or Password is wrong",Toast.LENGTH_SHORT).show();
            }

        }

    }


}



