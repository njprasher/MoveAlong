package com.codeblack.movealong;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.HashMap;
import java.util.Map;


public class SignupActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }
}


//
//    private void createUser() {
//
//        auth.createUserWithEmailAndPassword(etEmail.getText().toString(), etPassword.getText().toString())
//                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        Log.e(TAG, "onComplete: "+task.isSuccessful() );
//                        // If sign in fails, display a message to the user. If sign in succeeds
//                        // the auth state listener will be notified and logic to handle the
//                        // signed in user can be handled in the listener.
//                        if (!task.isSuccessful()) {
//                            printToast(activity,"Authentication failed." + task.getException());
//
//                        } else {
//                            addDataToFireStone();
//                        }
//                    }
//                });
//    }
//
//    private void addDataToFireStone() {
//
//        String userId = auth.getUid();
//
//        Map<String,Object> userMap = new HashMap<>();
//        userMap.put("userId",userId);
//        userMap.put("email",etEmail.getText().toString());
//        userMap.put("firstName", etFirstName.getText().toString());
//        userMap.put("lastName",etLastName.getText().toString());
//        userMap.put("password",etPassword.getText().toString());
//
//        DocumentReference newCityRef = dRef.collection("users").document(userId);
//        newCityRef.set(userMap).addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void aVoid) {
//                ShareSmilesPrefs.writeBool(activity,ShareSmilesPrefs.isLogin,true);
//                ShareSmilesPrefs.writeString(activity,ShareSmilesPrefs.emailId,etEmail.getText().toString());
//                ShareSmilesPrefs.writeString(activity,ShareSmilesPrefs.userName,etFirstName.getText().toString()+" "+etLastName.getText().toString());
//                ShareSmilesPrefs.writeString(activity,ShareSmilesPrefs.userId,userId);
//                ShareSmilesPrefs.writeString(activity,ShareSmilesPrefs.userPic,"");
//
//                startActivity(new Intent(activity,MainActivity.class));
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Log.e(TAG, "failure: " +e.getMessage());
//            }
//        });
//       /* dRef.collection("users")
//                .add(userMap).addOnSuccessListener(new OnSuccessListener< Void >() {
//            @Override
//            public void onSuccess(Void aVoid) {
//                printToast(activity,"Data Added");
//
//                Log.e(TAG, "onSuccess: " );
//            }
//        })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.e("TAG", e.toString());
//                    }
//                });*/
//    }
