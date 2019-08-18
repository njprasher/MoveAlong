package com.codeblack.movealong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.codeblack.movealong.Utilities.Utility;
import com.codeblack.movealong.Utilities.Validations;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.HashMap;
import java.util.Map;


public class SignupActivity extends AppCompatActivity {

    AppCompatActivity activity = SignupActivity.this;

    private EditText name;
    private EditText address;
    private EditText email;
    private EditText phone;
    private EditText password;
    private EditText re_Enter_Password;

    private Button btn_register;
    private TextView text_login;

    FirebaseAuth mAuth;
    FirebaseFirestore dRef = FirebaseFirestore.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        initView();

        text_login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent mIntent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(mIntent);
                finish();
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                create_User();
            }
        });

        mAuth = FirebaseAuth.getInstance();
        initView();

    }


    private void initView()
    {
        name = ((EditText)findViewById(R.id.input_name));
        address = ((EditText)findViewById(R.id.input_address));
        email = (EditText)findViewById(R.id.input_email);
        phone = (EditText)findViewById(R.id.input_mobile);
        password = (EditText)findViewById(R.id.input_password);
        re_Enter_Password = (EditText)findViewById(R.id.input_reEnterPassword);
        btn_register = (Button)findViewById(R.id.btn_signup);
        text_login = (TextView)findViewById(R.id.link_login);
    }


    private void create_User() {
        if(validate_Sign_Up_Data()){

            mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                addDataToFireStore();
//                              FirebaseUser user = mAuth.getCurrentUser();
//                              updateUI(user);
                            } else {
                                System.out.println("user not created");
                            }
                        }
                    });
        }
      }


    private void addDataToFireStore() {

        String uId = mAuth.getUid();

        Map<String, Object> userMap = new HashMap<>();

        userMap.put("email", email.getText().toString());
        userMap.put("name", name.getText().toString());
        userMap.put("password", password.getText().toString());
        userMap.put("address", address.getText().toString());
        userMap.put("phone", phone.getText().toString());

        DocumentReference newUsersRef = dRef.collection("users").document(uId);
        newUsersRef.set(userMap).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

                startActivity(new Intent(activity, LoginActivity.class));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                System.out.println("failure"+ e.getMessage());
            }
        });
    }

    private boolean validate_Sign_Up_Data(){

        if (name.getText().toString().isEmpty()){
            Utility.utility_Toast(getApplicationContext() ,"Please Enter Your Name");
            return false;

        }else if (address.getText().toString().isEmpty()){
            Utility.utility_Toast(getApplicationContext() ,"Please Enter Address");
            return false;
        }else if (email.getText().toString().isEmpty()){
            Utility.utility_Toast(getApplicationContext() ,"Please Enter Email ID");
            return false;
        }else if (!(Validations.is_Email_Valid(email.getText().toString()))){
            Utility.utility_Toast(getApplicationContext() ,"Please Enter Valid Email");
            return false;
        }else if (password.getText().toString().isEmpty()){
            Utility.utility_Toast(getApplicationContext() ,"Please Enter password");
            return false;
        }else if (re_Enter_Password.getText().toString().isEmpty()){
            Utility.utility_Toast(getApplicationContext() ,"Please re-Enter Password");
            return false;
        }else if (!Validations.isValidPassword(password.getText().toString())){
            Utility.utility_Toast(getApplicationContext() ,"Please Enter valid password");
            return false;
        }else if (!(password.getText().toString()).equals(re_Enter_Password.getText().toString())){
            Utility.utility_Toast(getApplicationContext() ,"Confirm password did not match");
            return false;
        }

        return true;
    }


}
