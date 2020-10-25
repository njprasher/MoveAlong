package com.codeblack.movealong;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.codeblack.movealong.Utilities.Utility;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class AddNewAdActivity extends AppCompatActivity {

    static int add_id = 0 ;

    private FirebaseAuth mAuth;
    private FirebaseFirestore dRef = FirebaseFirestore.getInstance();

    private EditText address;
    private EditText timetomove;
    private EditText prefer;
    private EditText details;
    private Button btnSubmitAd;
    public EditText budget;
    public EditText numberofpersons;
    public EditText title;

    public ImageView imageView;
    private Uri filePath;
//    private final int PICK_IMAGE_REQUEST = 71;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_ad);


        initView();

        btnSubmitAd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                add_properties();
            }
        });

        mAuth = FirebaseAuth.getInstance();
        initView();
    }



    public void initView(){

        title = (EditText)findViewById(R.id.title);
        address = (EditText)findViewById(R.id.address);
        timetomove = (EditText)findViewById(R.id.timetomove);
        budget = (EditText)findViewById(R.id.budget);
        numberofpersons = (EditText)findViewById(R.id.numberofpersons);
        prefer = (EditText)findViewById(R.id.prefer);
        details = (EditText)findViewById(R.id.details);
        imageView = (ImageView) findViewById(R.id.uploadimage);
        btnSubmitAd = (Button) findViewById(R.id.btnSubmitAd);

    }


    public void add_properties(){

////        filePath = add_image();
//
          String userId = mAuth.getUid();


        HashMap<String, Object> propertyMap = new HashMap<>();
            propertyMap.put("aId", ++add_id);
            propertyMap.put("uId", userId);
            propertyMap.put("is_active", 0);
            propertyMap.put("title", title.getText().toString());
            propertyMap.put("address", address.getText().toString());
            propertyMap.put("timetomove", timetomove.getText().toString());
            propertyMap.put("Budget", budget.getText().toString());
            propertyMap.put("numberofpersons", numberofpersons.getText().toString());
            propertyMap.put("prefer", prefer.getText().toString());
            propertyMap.put("details", details.getText().toString());

//            propertyMap.put("itemImage", path);

        //        CollectionReference userRef = dRef.collection("users").document(userId).collection("products");
        CollectionReference propertyRef = dRef.collection("properties");
            propertyRef.add(propertyMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Intent mIntent = new Intent(AddNewAdActivity.this, TabViewActivity.class);
                startActivity(mIntent);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Utility.utility_Toast(AddNewAdActivity.this,"Could not add new property please try again");
            }
        });
    }

}
