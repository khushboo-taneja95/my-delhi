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
import com.letsdowebsite.mydelhi.adapter.TempleAdapter;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import model.TempleData;


public class TempleFragment extends Fragment {
    private View view;
    private Context mcontext;
    private TempleAdapter mtempleAdapter;
    ArrayList<TempleData>dataArrayList;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    static View.OnClickListener myOnClickListener;
    RecyclerView metrostationlist;
    ImageView imageicon;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.listtemple_temple, viewGroup, false);

         metrostationlist = (RecyclerView)view.findViewById(R.id.my_recycler_view);
        metrostationlist.setLayoutManager(new LinearLayoutManager(getActivity()));

       // imageicon=(ImageView)view.findViewById( R.id.imageicon );
        Picasso.with(getActivity())
                .load("https://www.partyone.in/suploads/2016/Jul/20/18890/14690042751.jpg");
              //  .into(imageicon);


     //   metrostationlist.setAdapter(new TempleAdapter(name));
        String jsonvalue = loadJSONFromAsset(getActivity());
        getJsonValue(jsonvalue);
        return view;
    }
    public String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open( "temple.json" );
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
            dataArrayList = new ArrayList<TempleData>();

            JSONObject obj = new JSONObject( jsonValue );
            JSONArray jsonArray = obj.getJSONArray( "temple" );
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject( i );
                TempleData data = new TempleData();
                data.setName (object.getString( "temple name" ));
                data.setURL( object.getString( "temple URL" ) );
                data.setLatitude( object.getString( "Latitude" ) );
                data.setLongitude( object.getString( "Longitude" ) );
                dataArrayList.add( data );
            }

            mtempleAdapter = new TempleAdapter( getActivity(), dataArrayList ) ;
            metrostationlist.setAdapter( (TempleAdapter) mtempleAdapter );



        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}


