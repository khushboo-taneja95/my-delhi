package com.letsdowebsite.mydelhi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.letsdowebsite.mydelhi.adapter.ListAdapter;

public class list_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleview_metro );
        RecyclerView list1=(RecyclerView) findViewById( R.id.list1 );
        list1.setLayoutManager( new LinearLayoutManager( this ) );
        String[]name= {"Badarpur",
                "Tughlakabad",
                "Mohan Estate",
                "Sarita Vihar",
                "Jasolo Apollo",
                "Okhla",
                "Govind puri",

                "Kalka Ji"};
       list1.setAdapter( new ListAdapter(name ) );
    }
}
