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
import com.letsdowebsite.mydelhi.adapter.FireAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import model.FireData;

/**
 * Created by Khushboo on 3/12/2018.
 */

public class FireFragment extends Fragment {
    private View view;
    ArrayList<FireData> dataArrayList;
    private Context mcontext;
    private FireAdapter mfireAdapter;
    ImageView imageFire;
    TextView txtTitle;
    RecyclerView metrostationlist;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    static View.OnClickListener myOnClickListener;

    @Override
    public void onAttach(Context context) {
        mcontext = context;
        super.onAttach( context );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.listfire_fire, viewGroup, false);

         metrostationlist = (RecyclerView)view.findViewById(R.id.my_recycler_view);
        metrostationlist.setLayoutManager(new LinearLayoutManager(getActivity()));




       // imageFire=(ImageView)view.findViewById( R.id.imageFire );
        txtTitle=(TextView)view.findViewById( R.id.txtTitle );
        //  Picasso.with(getActivity())
        //        .load("https://upload.wikimedia.org/wikipedia/commons/1/11/Steelhouse_Lane_police_station_-_2014-03-25_-_Andy_Mabbett_-_07.JPG")
        //      .into(imageFire);


        // metrostationlist.setAdapter(new FireAdapter(name));
        String jsonvalue = loadJSONFromAsset(getActivity());
        getJsonValue(jsonvalue);
        return view;
    }
    public String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open( "fire.json" );
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
            dataArrayList = new ArrayList<FireData>();

            JSONObject obj = new JSONObject( jsonValue );
            JSONArray jsonArray = obj.getJSONArray( "fire" );
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject( i );
                FireData data = new FireData();
                data.setName (object.getString( "fire name" ));
                data.setAddress( object.getString( "fire address" ) );
                data.setPhonenumber( object.getString( "phone number" ) );
                data.setLatitude( object.getString( "Latitude" ) );
                data.setLongitude( object.getString( "Longitude" ) );

                dataArrayList.add( data );
            }

            mfireAdapter = new FireAdapter( mcontext, dataArrayList ) ;
            metrostationlist.setAdapter( (FireAdapter) mfireAdapter );



        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}



