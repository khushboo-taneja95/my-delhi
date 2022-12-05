package com.letsdowebsite.mydelhi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;


public class metro1 extends AppCompatActivity {
    RecyclerView mrecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleview_metro );
        mrecyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        String[]name= {"Badarpur","Tughlakabad","Mohan Estate","Sarita Vihar","Jasolo Apollo","Okhla","Govind puri","Kalka Ji"};




    }
}
