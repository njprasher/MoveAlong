package com.codeblack.movealong.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.codeblack.movealong.R;
import com.codeblack.movealong.Utilities.MyListData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class OneFragment extends Fragment {

    private FirebaseFirestore dbref = FirebaseFirestore.getInstance();

    //get the title of ad
    public String  title;
    public String  address;
    public String  detail;
    public String  is_active;
    public String  place;
    public String  prefer;
    public String  timetomove;
    public String  numberofperson;
    public String  uId;
    public String  budget;

    public MyListData mydata;
    //    MyListData[] myListData = new MyListData[]{};
    ArrayList<MyListData> myListData = new ArrayList<MyListData>();

    FloatingActionButton addProduct;
    private FirebaseFirestore dRef = FirebaseFirestore.getInstance();

    public OneFragment() {
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
        View mView = inflater.inflate(R.layout.fragment_one, container, false);

        //getting reference to recycler view

//        RecyclerView recyclerView = mView.findViewById(R.id.myRecyclerView);
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//        recyclerView.setHasFixedSize(true);

        //data for recycler view

//
//        dbref.collection("properties").addSnapshotListener(new EventListener<QuerySnapshot>() {
//            @Override
//            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
//
//                for (DocumentChange documentChange : documentSnapshots.getDocumentChanges()) {
//                    if(!documentChange.getDocument().getData().isEmpty()) {
//                        title = documentChange.getDocument().getData().get("title").toString();
//                        address = documentChange.getDocument().getData().get("address").toString();
//                        detail = documentChange.getDocument().getData().get("details").toString();
//                        is_active = documentChange.getDocument().getData().get("is_active").toString();
//                        place = documentChange.getDocument().getData().get("place").toString();
//                        prefer = documentChange.getDocument().getData().get("prefer").toString();
//                        numberofperson = documentChange.getDocument().getData().get("numberofperson").toString();
//                        timetomove = documentChange.getDocument().getData().get("timetomove").toString();
//                        budget = documentChange.getDocument().getData().get("Budget").toString();
//                        uId = documentChange.getDocument().getData().get("uId").toString();
//
//                        mydata = new MyListData(title, numberofperson, budget, detail, address,
//                                timetomove, is_active, uId, prefer);
//
//                        myListData.add(mydata);
//                    }
//                }
//                }
//        });
//
//
//        MyListAdapter myListAdapter = new MyListAdapter(myListData);
//
//        recyclerView.setAdapter(myListAdapter);

        // Inflate the layout for this fragment
        return mView;
    }


}
