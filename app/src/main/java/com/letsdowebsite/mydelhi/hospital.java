package com.letsdowebsite.mydelhi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class hospital extends AppCompatActivity {
    ImageView imgIcon;
    String name;
    String URL;
    String Address;
    TextView textName;
    String Phonenumber;
    TextView textAddress;

    TextView textPhonenumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.hospitaldesign );
        textName=(TextView) findViewById( R.id.textName );
        textAddress=(TextView) findViewById( R.id.textAddrees );
        textPhonenumber=(TextView)findViewById( R.id.textPhoneNumber ) ;

        imgIcon = (ImageView) findViewById( R.id.back );
        imgIcon.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hospital.this.finish();
            }
        });

        URL = getIntent().getStringExtra( "URL" );
        name = getIntent().getStringExtra("name");
        Address = getIntent().getStringExtra( "Address" );
        Phonenumber = getIntent().getStringExtra( "Phonenumber" );
        textName.setText( name );
        textAddress.setText( Address );
        textPhonenumber.setText( Phonenumber );

        System.out.print("name"+name);
        System.out.print("Phonenumber"+Phonenumber);
        System.out.print("Address"+Address);
    }
}
