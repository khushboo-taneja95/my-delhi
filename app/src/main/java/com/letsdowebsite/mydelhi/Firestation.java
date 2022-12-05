package com.letsdowebsite.mydelhi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class Firestation extends AppCompatActivity {
    ImageView back;
    String name;
    TextView txtTitle;
    String Address;
    String Phonenumber;
    String Latitude;
    TextView textName;
    String Longtitude;
    TextView textAddress;
    TextView textLatitude;
    TextView textPhonenumber;
    TextView  textLongtitude;
    ImageView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.firedesign);
        textName=(TextView) findViewById( R.id.textName );
         textAddress=(TextView) findViewById( R.id.textAddrees );
         textPhonenumber=(TextView)findViewById( R.id.textPhoneNumber ) ;
         textLatitude=(TextView)findViewById( R.id.textLatitude );
        textLongtitude=(TextView)findViewById( R.id.textLongtitude );
        map=(ImageView) findViewById( R.id.map );


     //   text=(TextView)findViewById (R.id.text);
      //  text.setText( Address );
       // text1 = (TextView) findViewById( R.id.text1 );
       // text1.setText( Phonenumber );

        back = (ImageView) findViewById( R.id.back );
        back.setOnClickListener( new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Firestation.this.finish();
    }
});
        name = getIntent().getStringExtra("name");
        Address = getIntent().getStringExtra( "Address" );
        Phonenumber = getIntent().getStringExtra( "Phonenumber" );
        Latitude = getIntent().getStringExtra( "Latitude" );
        Longtitude = getIntent().getStringExtra( "Longtitude" );


        textName.setText( name );
        textAddress.setText( Address );
        textPhonenumber.setText( Phonenumber );
        textLatitude.setText( Latitude );
        textLongtitude.setText( Longtitude );

        System.out.print("name"+name);
        System.out.print("Phonenumber"+Phonenumber);
        System.out.print("Address"+Address);
        System.out.print("Latitude"+Latitude);
        System.out.print("Longtitude"+Longtitude);
        String latEiffelTower = Latitude;
        String lngEiffelTower = Longtitude;

        String url = "http://maps.google.com/maps/api/staticmap?center=" + latEiffelTower + "," + lngEiffelTower + "&zoom=15&size=200x200&sensor=false";
        Picasso.with(Firestation.this)
                .load(url)
                .into(map);

    }
}







