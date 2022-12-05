package com.letsdowebsite.mydelhi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class metro extends AppCompatActivity {
    View view;
    String source;
    String destination;
    String color;
    RecyclerView my_recycler_view;
    View Viewcolor;
    TextView textcolor;
     TextView textsource;
     TextView textdestination;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.fragment_metro );
       Viewcolor=(View) findViewById( R.id.tvColor );
      textsource=(TextView) findViewById( R.id.tvSource );
      textdestination=(TextView) findViewById( R.id.tvDistanction );


        my_recycler_view =(RecyclerView) findViewById( R.id. my_recycler_view);
        my_recycler_view.setOnClickListener(  new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent( metro.this, list_view.class );
               startActivity( intent );
           }
       });



        source = getIntent().getStringExtra( "source");
        destination = getIntent().getStringExtra( "destination");
        color = getIntent().getStringExtra( "color" );

        textcolor.setText(color);
        textsource.setText(source);
        textdestination.setText(destination);

        System.out.print("source"+source);
        System.out.print("destination" + destination);
        System.out.print("color"+color);
    }
}