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
import com.letsdowebsite.mydelhi.adapter.FeedAdapter;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import model.FeedData;


public class FeedFragment extends Fragment {
    private View view;
    private Context mcontext;
    ArrayList<FeedData>dataArrayList;
    RecyclerView metrostationlist;
    private FeedAdapter mfeedAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    static View.OnClickListener myOnClickListener;
    ImageView imageFeed;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.list_item_layout, viewGroup, false);
        metrostationlist = (RecyclerView)view.findViewById(R.id.my_recycler_view);
        metrostationlist.setLayoutManager(new LinearLayoutManager(getActivity()));

       // imageFeed=(ImageView)view.findViewById( R.id.imageIcon1 );
        Picasso.with(getActivity())
                .load("http://indiapicks.com/Images/Humayun_Tomb/HTC_Humayun_Tomb_South_Face.JPG");
               // .into(imageFeed);
       // metrostationlist.setAdapter(new FeedAdapter(name));
        String jsonvalue = loadJSONFromAsset(getActivity());
        getJsonValue(jsonvalue);
        return view;
    }
    public String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("feed.json");
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
            dataArrayList = new ArrayList<FeedData>();

            JSONObject obj = new JSONObject( jsonValue );
            JSONArray jsonArray = obj.getJSONArray( "feed" );
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject( i );
                FeedData data = new FeedData();
                data.setName (object.getString( "feed name" ));
                data.setURL( object.getString( "feed URL" ) );
                dataArrayList.add( data );
            }

            mfeedAdapter = new FeedAdapter( mcontext, dataArrayList ) ;
            metrostationlist.setAdapter( (FeedAdapter) mfeedAdapter );



        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}

