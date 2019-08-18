package com.codeblack.movealong.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.codeblack.movealong.AddNewAdActivity;
import com.codeblack.movealong.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TwoFragment extends Fragment {

    FloatingActionButton addProduct;

    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_two, container, false);
        addProduct = mView.findViewById(R.id.addProduct);

        addProduct.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent mIntent = new Intent(getActivity() , AddNewAdActivity.class);
                startActivity(mIntent);
            }
        });


        return mView;
    }

}
