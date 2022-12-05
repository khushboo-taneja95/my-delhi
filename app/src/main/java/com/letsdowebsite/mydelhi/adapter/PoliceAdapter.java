package com.letsdowebsite.mydelhi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.letsdowebsite.mydelhi.R;
import com.letsdowebsite.mydelhi.Policestation;

import java.util.ArrayList;

import model.PoliceData;


public class PoliceAdapter  extends RecyclerView.Adapter<PoliceAdapter.PoliceViewHolder> {

    Context context ;
    ArrayList<PoliceData> myList;

    public PoliceAdapter(Context context, ArrayList<PoliceData> myList) {
        this.myList = myList;
        this.context = context;
    }
    @Override
    public PoliceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
        View view = inflater.inflate( R.layout.singleview_police, parent, false );
        return new PoliceViewHolder( view );
    }

    @Override
    public void onBindViewHolder(PoliceAdapter.PoliceViewHolder holder, int size) {
        PoliceData title = myList.get(size);
        holder.txtTitle.setText(title.getName());
       // Log.e("tag","message"+title.getURL());
        //Picasso.with(context)
          //      .load(title.getURL())
            //    .into(holder.imagePolice);

    }


    @Override
    public int getItemCount() {
        return myList.size();
    }




    public class PoliceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
       // ImageView imagePolice;
        TextView txtTitle;

        public PoliceViewHolder(View itemView) {
            super( itemView );
           // imagePolice = (ImageView) itemView.findViewById( R.id.imagePolice );
            txtTitle = (TextView) itemView.findViewById( R.id.txtTitle);
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



            Intent intent = new Intent(context, Policestation.class);
            intent.putExtra("name",name);
            intent.putExtra( "Phonenumber",Phonenumber );
            intent.putExtra( "Address",Address );
            intent.putExtra( "Latitude",Latitude );
            intent.putExtra( "Longtitude",Longtitude );
            context.startActivity(intent);

        }
    }
}