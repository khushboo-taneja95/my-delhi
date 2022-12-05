package com.letsdowebsite.mydelhi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.letsdowebsite.mydelhi.R;
import com.letsdowebsite.mydelhi.Firestation;

import java.util.ArrayList;

import model.FireData;


public class FireAdapter extends RecyclerView.Adapter<FireAdapter.fireViewHolder>  {

    Context context;
    ArrayList<FireData> myList;
    public FireAdapter(Context context, ArrayList<FireData> myList) {
        this.myList = myList;
        this.context = context;

    }

    @Override
    public FireAdapter.fireViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
        View view = inflater.inflate( R.layout.singleview_fire, parent, false );
        return new fireViewHolder( view );


    }

    @Override
    public void onBindViewHolder(FireAdapter.fireViewHolder holder, int size) {
        FireData title = myList.get( size );
        holder.txtTitle.setText( title.getName() );
        //Log.e("tag","message"+title.getURL());

    }
    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class fireViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{

        TextView txtTitle;
        public fireViewHolder(View itemView) {
            super( itemView );
           // imageFire = (ImageView) itemView.findViewById( R.id.imageFire );
            txtTitle = (TextView) itemView.findViewById( R.id.txtTitle );
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            int Position = getAdapterPosition();

            String name = myList.get(Position).getName();
            String Phonenumber = myList.get(Position).getPhonenumber();
            String Address = myList.get(Position).getAddress();
            String Latitude= myList.get(Position).getLatitude();
            String Longtitude =myList.get(Position).getLongitude();



            Intent intent = new Intent(context, Firestation.class);
            intent.putExtra("name",name);
            intent.putExtra( "Phonenumber",Phonenumber );
            intent.putExtra( "Address",Address );
            intent.putExtra( "Latitude",Latitude );
            intent.putExtra( "Longtitude",Longtitude );
            context.startActivity(intent);

        }
    }
}