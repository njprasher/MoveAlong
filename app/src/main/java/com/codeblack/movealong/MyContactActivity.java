package com.codeblack.movealong;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MyContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_contact);
    }public void onCall(View view) {
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MyContactActivity.this,new String[] {Manifest.permission.CALL_PHONE},1);
        } else {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:28932330609"));
            startActivity(intent);
        }
    }
    public void onEmail(View  view) {

    }
    public void onSms(View  view) {
        if (ActivityCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.SEND_SMS)!=PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MyContactActivity.this,new String[] {Manifest.permission.SEND_SMS},1);;
        }
        else {
//            SmsManager smsManager = SmsManager.getDefault();
//////            smsManager.sendTextMessage("1234567890",null,"Hello",null);
            Intent intent = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:28932330609"));
            intent.putExtra("SMS BODY","Sample message");
            startActivity(intent);

        }
    }
}
