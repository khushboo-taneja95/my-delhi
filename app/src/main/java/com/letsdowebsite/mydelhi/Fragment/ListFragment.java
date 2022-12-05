package com.letsdowebsite.mydelhi.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.letsdowebsite.mydelhi.R;
import com.letsdowebsite.mydelhi.adapter.ListAdapter;

/**
 * Created by Khushboo on 3/12/2018.
 */

public class ListFragment  extends Fragment {
    private View view;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    static View.OnClickListener myOnClickListener;
    String[]name= {"Badarpur","Tughlakabad","Mohan Estate","Sarita Vihar","Jasolo Apollo","Okhla","Govind puri","Kalka Ji","Nehru Place",
    "Kailash Colony","Moolchand","Lajpat Nagar","Jangpura","Jawaharlal Nehru Stadium","Khan Market","Central Secretariat",
    "Janpath","fdhdfh","Mandi House"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.listmetro, viewGroup, false);
        RecyclerView metrostationlist = (RecyclerView)view.findViewById(R.id.list1);
        metrostationlist.setLayoutManager(new LinearLayoutManager(getActivity()));


        metrostationlist.setAdapter(new ListAdapter(name));



        return view;
    }
}


