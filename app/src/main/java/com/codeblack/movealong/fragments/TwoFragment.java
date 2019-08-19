package com.codeblack.movealong.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codeblack.movealong.AddNewAdActivity;
import com.codeblack.movealong.MyListAdapter;
import com.codeblack.movealong.R;
import com.codeblack.movealong.Utilities.MyListData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

public class TwoFragment extends Fragment  {

    MyListData[] myDataList;
    private FirebaseFirestore dbref = FirebaseFirestore.getInstance();

    private MyListAdapter myListAdapter = new MyListAdapter(MyListData.myListData);

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
    FirebaseAuth mAuth;
//    MyListData[] myListData = new MyListData[]{};



    FloatingActionButton addProduct;
    private FirebaseFirestore dRef = FirebaseFirestore.getInstance();

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

        //getting reference to recycler view

        RecyclerView recyclerView = mView.findViewById(R.id.myAdsRecyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.setHasFixedSize(true);

        //data for recycler view


        dbref.collection("properties").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                int arr_Size = 1;
                for (DocumentChange documentChange : documentSnapshots.getDocumentChanges()) {
//                    if(!documentChange.getDocument().getData().isEmpty()) {
                        title = documentChange.getDocument().getData().get("title").toString();
                        address = documentChange.getDocument().getData().get("address").toString();
                        detail = documentChange.getDocument().getData().get("details").toString();
                        is_active = documentChange.getDocument().getData().get("is_active").toString();
                        prefer = documentChange.getDocument().getData().get("prefer").toString();
                        numberofperson = documentChange.getDocument().getData().get("numberofpersons").toString();
                        timetomove = documentChange.getDocument().getData().get("timetomove").toString();
                        budget = documentChange.getDocument().getData().get("Budget").toString();
                        uId = documentChange.getDocument().getData().get("uId").toString();


//                        FirebaseUser user = mAuth.getCurrentUser();
 //                       if( user.getUid()!=null) {
                  //  System.out.println(user.getUid());
                    System.out.println(uId);
                            mydata = new MyListData(title, numberofperson, budget, detail, address,
                                    timetomove, is_active, uId, prefer);
                            MyListData.myListData.add(mydata);
 //                       }


//                    }
                }

//                myDataList = MyListData.myListData.toArray(new MyListData [MyListData.myListData.size()]);


            }
        });

//            if (myDataList.length > 0) {
                MyListAdapter myListAdapter = new MyListAdapter(MyListData.myListData);
//            }

        recyclerView.setAdapter(myListAdapter);


//         Inflate the layout for this fragment
        return mView;


    }


}
