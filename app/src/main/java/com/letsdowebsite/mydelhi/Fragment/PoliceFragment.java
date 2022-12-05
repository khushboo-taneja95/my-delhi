package com.letsdowebsite.mydelhi.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.letsdowebsite.mydelhi.R;
import com.letsdowebsite.mydelhi.adapter.PoliceAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import model.PoliceData;

/**
 * Created by Khushboo on 3/12/2018.
 */

public class PoliceFragment extends Fragment {
    private View view;
    ArrayList<PoliceData>dataArrayList;
    private Context mcontext;
    private PoliceAdapter mpoliceAdapter;
    private static RecyclerView.Adapter adapter;
    ImageView imagePolice;
    TextView txtTitle;
    RecyclerView metrostationlist;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    static View.OnClickListener myOnClickListener;


  //  String latEiffelTower = "48.858235";
   // String lngEiffelTower = "2.294571";

    @Override
    public void onAttach(Context context) {
        mcontext = context;
        super.onAttach( context );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.listpolice_police, viewGroup, false);

        metrostationlist = (RecyclerView)view.findViewById(R.id.my_recycler_view1);
        metrostationlist.setLayoutManager(new LinearLayoutManager(getActivity()));

       // Picasso.with(getActivity());

      //  .load("http://maps.google.com/maps/api/staticmap?center=" + latEiffelTower + "," + lngEiffelTower +
           //     "&zoom=15&size=200x200&sensor=false");


      //  imagePolice=(ImageView)view.findViewById( R.id.imagePolice );
        txtTitle=(TextView)view.findViewById( R.id.txtTitle );
     //  Picasso.with(getActivity())
       //        .load("https://upload.wikimedia.org/wikipedia/commons/1/11/Steelhouse_Lane_police_station_-_2014-03-25_-_Andy_Mabbett_-_07.JPG")
       //        .into(imagePolice);


        // metrostationlist.setAdapter(new HospitalAdapter( name ));
        String jsonvalue = loadJSONFromAsset(getActivity());
        getJsonValue(jsonvalue);
        return view;
    }
    public String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open( "police.json" );
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public void getJsonValue(String jsonValue){
        try {
            dataArrayList = new ArrayList<PoliceData>();

            JSONObject obj = new JSONObject( jsonValue );
            JSONArray jsonArray = obj.getJSONArray( "police" );
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject( i );
                PoliceData data = new PoliceData();
                data.setName (object.getString( "police name" ));
                data.setAddress( object.getString( "police address" ) );
                data.setPhonenumber( object.getString( "phone number" ) );
                data.setLatitude( object.getString( "Latitude" ) );
                data.setLongitude( object.getString( "Longitude" ) );

                dataArrayList.add( data );
            }

            mpoliceAdapter = new PoliceAdapter( mcontext, dataArrayList ) ;
            metrostationlist.setAdapter( (PoliceAdapter) mpoliceAdapter );



        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}





