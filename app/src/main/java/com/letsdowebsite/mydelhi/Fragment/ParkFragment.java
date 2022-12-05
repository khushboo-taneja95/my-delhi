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

import com.letsdowebsite.mydelhi.R;

import com.letsdowebsite.mydelhi.adapter.ParkAdapter;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import model.ListData;


public class ParkFragment extends Fragment {
    private View view;
    private Context mcontext;
    ArrayList<ListData>dataArrayList;
    private ParkAdapter mparkAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    static View.OnClickListener myOnClickListener;
    RecyclerView metrostationlist;
     ImageView imgIcon2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.listpark_park, viewGroup, false );

        metrostationlist = (RecyclerView) view.findViewById( R.id.my_recycler_view );
        metrostationlist.setLayoutManager( new LinearLayoutManager( getActivity() ) );

       // imgIcon2=(ImageView)view.findViewById( R.id.imgIcon2 );
        Picasso.with(getActivity())
                .load("https://upload.wikimedia.org/wikipedia/commons/9/95/Trees-wandsworth-park.JPG");
              //  .into(imgIcon2);
      //  metrostationlist.setAdapter( new ParkAdapter( name ) );

        String jsonvalue = loadJSONFromAsset(getActivity());
        getJsonValue(jsonvalue);
        return view;
    }
    public String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("park.json");
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
            dataArrayList = new ArrayList<ListData>();

            JSONObject obj = new JSONObject( jsonValue );
            JSONArray jsonArray = obj.getJSONArray( "park" );
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject( i );
                ListData data = new ListData();
                data.setName (object.getString( "park name" ));
                data.setURL( object.getString( "park URL" ) );
                data.setLatitude( object.getString( "Latitude" ) );
                data.setLongitude( object.getString( "Longitude" ) );
                dataArrayList.add( data );
            }

            mparkAdapter = new ParkAdapter( getActivity(), dataArrayList ) ;
            metrostationlist.setAdapter( (ParkAdapter) mparkAdapter );



        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
