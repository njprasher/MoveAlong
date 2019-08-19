package com.codeblack.movealong.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.codeblack.movealong.MyContactActivity;
import com.codeblack.movealong.MyWebView;
import com.codeblack.movealong.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

public class FourFragment extends Fragment {

    private FirebaseFirestore dbref = FirebaseFirestore.getInstance();

    private String currentUid;

    private TextView name;
    private TextView address;
    private TextView email;
    private TextView phone;
    private Button about_us;
    private Button contact_us;

    FirebaseAuth mAuth;
    public FourFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

            dbref.collection("users").addSnapshotListener(new EventListener<QuerySnapshot>() {
                @Override
                public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                    for (DocumentChange documentChange : documentSnapshots.getDocumentChanges()) {

                            name.setText(documentChange.getDocument().getData().get("name").toString());
                            address.setText(documentChange.getDocument().getData().get("address").toString());
                            email.setText(documentChange.getDocument().getData().get("email").toString());
                            phone.setText(documentChange.getDocument().getData().get("phone").toString());

                    }

                }
            });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_four, container, false);

        name = mView.findViewById(R.id.lblName);
        address = mView.findViewById(R.id.lblAddress);
        email = mView.findViewById(R.id.lblEmail);
        phone = mView.findViewById(R.id.lblPhone);
        about_us = mView.findViewById(R.id.about_us);
        contact_us = mView.findViewById(R.id.contact_us);

        about_us.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(view.getContext(), MyWebView.class);
                view.getContext().startActivity(intent);
            }
        });
        contact_us.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(view.getContext(), MyContactActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        return mView;
    }
}