package com.letsdowebsite.mydelhi.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.letsdowebsite.mydelhi.R;

/**
 * Created by Dell on 3/6/2018.
 */

public class MainFragment extends Fragment{
    private View view;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
   static View.OnClickListener myOnClickListener;
  //  String[]name= {"Khushboo","Heena","Mamta","Suman","Mohit","Naveen","Deepa","Naveen","Sandeep","Neelu","Nitin"};

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup viewGroup, Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_home, viewGroup, false);
        RecyclerView metrostationlist = (RecyclerView)view.findViewById(R.id.my_recycler_view);
        metrostationlist.setLayoutManager(new LinearLayoutManager(getActivity()));


       // metrostationlist.setAdapter(new MetroAdapter(name));



        return view;
    }
}
