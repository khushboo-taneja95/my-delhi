package com.letsdowebsite.mydelhi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;


public class feed extends AppCompatActivity {
    ImageView imageIcon1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.singleview_feed );
        final RecyclerView list = (RecyclerView) findViewById( R.id.my_recycler_view );
        list.setLayoutManager( new LinearLayoutManager( this ) );
        //imageIcon1 = (ImageView) findViewById( R.id.imgIcon );
        imageIcon1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( feed.this, list.getClass() );

            }


        } );
    }
}
