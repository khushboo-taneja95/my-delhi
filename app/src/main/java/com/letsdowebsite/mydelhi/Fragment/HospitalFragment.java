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
import com.letsdowebsite.mydelhi.adapter.HospitalAdapter;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import model.HospitalData;



public class HospitalFragment extends Fragment {
    private View view;
    private Context mcontext;
    private HospitalAdapter mhospitalAdapter;
    ArrayList<HospitalData>dataArrayList;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    ImageView imageHospital;
    RecyclerView metrostationlist;
    static View.OnClickListener myOnClickListener;

    String latEiffelTower = "48.858235";
    String lngEiffelTower = "2.294571";

    @Override
    public void onAttach(Context context) {
        mcontext = context;
        super.onAttach( context );
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.listhospital_hospital, viewGroup, false);

        metrostationlist = (RecyclerView)view.findViewById(R.id.my_recycler_view);
        metrostationlist.setLayoutManager(new LinearLayoutManager(getActivity()));

       // imageHospital=(ImageView)view.findViewById( R.id.imgIcon );
        Picasso.with(getActivity())
                .load("http://www.bestwebsiteinindia.com/blog/wp-content/uploads/2014/09/Sri-Ganga-Ram-Hospital.jpg");
//                .into(imageHospital);


       // metrostationlist.setAdapter(new HospitalAdapter( name ));
        String jsonvalue = loadJSONFromAsset(getActivity());
        getJsonValue(jsonvalue);
        return view;
    }
    public String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open( "hospital.json" );
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
            dataArrayList = new ArrayList<HospitalData>();

            JSONObject obj = new JSONObject( jsonValue );
            JSONArray jsonArray = obj.getJSONArray( "hospital" );
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject( i );
                HospitalData data = new HospitalData();
                data.setName (object.getString( "hospital name" ));
                data.setURL( object.getString( "hospital URL" ) );
                data.setAddress( object.getString( "hospital address" ) );
                data.setPhonenumber( object.getString( "phone number" ) );
                dataArrayList.add( data );
            }

            mhospitalAdapter = new HospitalAdapter( mcontext, dataArrayList ) ;
            metrostationlist.setAdapter( (HospitalAdapter) mhospitalAdapter );



        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}



