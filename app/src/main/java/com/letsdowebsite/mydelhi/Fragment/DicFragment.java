package com.letsdowebsite.mydelhi.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.letsdowebsite.mydelhi.R;
import com.letsdowebsite.mydelhi.adapter.DicAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import model.DelhiData;


/**
 * Created by Khushboo on 3/15/2018.
 */

public class DicFragment extends Fragment {
    private View view;
    ArrayList<DelhiData> dataArrayList;
    private Context mcontext;
    private DicAdapter mdicAdapter;
    RecyclerView metrostationlist;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    static View.OnClickListener myOnClickListener;
 //   String[]name= {"Badarpur","Tughlakabad","Mohan Estate","Sarita Vihar","Jasolo Apollo","Okhla","Govind puri","Kalka Ji"};

    @Override
    public void onAttach(Context context) {
        mcontext = context;
        super.onAttach( context );
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.dic, viewGroup, false);


        metrostationlist = (RecyclerView)view.findViewById(R.id.my_recycler_view);
        metrostationlist.setLayoutManager(new LinearLayoutManager(getActivity()));

      //  metrostationlist.setAdapter(new DicAdapter(name));

        String jsonvalue = loadJSONFromAsset(getActivity());
        getJsonValue(jsonvalue);
        return view;
    }
    public String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open( "metro.json");
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
            dataArrayList = new ArrayList<DelhiData>();

            JSONObject obj = new JSONObject( jsonValue );
            JSONArray jsonArray = obj.getJSONArray( "metro");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject( i );
                DelhiData data = new DelhiData();
                data.setSource (object.getString( "source"));
                data.setDestination( object.getString( "destination"));
                data.setColor( object.getString( "color"));


                dataArrayList.add( data );
            }

            mdicAdapter = new DicAdapter( mcontext, dataArrayList) ;
            metrostationlist.setAdapter( (DicAdapter) mdicAdapter);



        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}


