package com.letsdowebsite.mydelhi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


/**
 * Created by Khushboo on 3/15/2018.
 */

public class dic extends AppCompatActivity {
    View view;
    String source;
    String destination;
    String color;
    View Viewcolor;
    TextView textcolor;
    TextView textsource;
    TextView textdestination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dic );
        Viewcolor=(View) findViewById( R.id.tvColor );
        textsource=(TextView) findViewById( R.id.tvSource );
        textdestination=(TextView) findViewById( R.id.tvDistanction );

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


