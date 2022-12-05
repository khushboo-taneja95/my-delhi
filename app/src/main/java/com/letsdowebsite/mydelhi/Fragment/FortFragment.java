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
import com.letsdowebsite.mydelhi.adapter.FortAdapter;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import model.FortData;

/**
 * Created by Khushboo on 3/13/2018.
 */

public class FortFragment  extends Fragment {
    private View view;
    private Context mcontext;
    ArrayList<FortData>dataArrayList;
    private FortAdapter mfortAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    static View.OnClickListener myOnClickListener;
    RecyclerView metrostationlist;
    ImageView imageIcon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.list_itemfort, viewGroup, false);
        metrostationlist = (RecyclerView)view.findViewById(R.id.my_recycler_view);
        metrostationlist.setLayoutManager(new LinearLayoutManager(getActivity()));

    //   imageIcon=(ImageView)view.findViewById( R.id.imageIcon );
        Picasso.with(getActivity())
                .load("https://www.thehistoryhub.com/wp-content/uploads/2014/04/Red-Fort-Images.jpg");
               // .into(imageIcon);

      //  metrostationlist.setAdapter(new FortAdapter(name));

        String jsonvalue = loadJSONFromAsset(getActivity());
        getJsonValue(jsonvalue);
        return view;
    }
    public String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("fort.json");
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
            dataArrayList = new ArrayList<FortData>();

            JSONObject obj = new JSONObject( jsonValue );
            JSONArray jsonArray = obj.getJSONArray( "fort" );
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject( i );
                FortData data = new FortData();
                data.setName (object.getString( "fort name" ));
                data.setURL( object.getString( "fort URL" ) );
                data.setLatitude( object.getString( "Latitude" ) );
                data.setLongitude( object.getString( "Longitude" ) );
                dataArrayList.add( data );
            }

            mfortAdapter = new FortAdapter( getActivity(), dataArrayList ) ;
            metrostationlist.setAdapter( (FortAdapter)mfortAdapter);



        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}

