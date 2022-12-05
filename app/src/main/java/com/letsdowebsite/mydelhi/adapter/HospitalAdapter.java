package com.letsdowebsite.mydelhi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.letsdowebsite.mydelhi.R;
import com.letsdowebsite.mydelhi.hospital;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import model.HospitalData;


public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder> {
    Context context ;
    ArrayList<HospitalData> myList;

    public HospitalAdapter(Context context, ArrayList<HospitalData> myList) {
        this.myList = myList;
        this.context = context;
    }

    @Override
    public HospitalAdapter.HospitalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
        View view = inflater.inflate( R.layout.singleview_hospital, parent, false );
        return new HospitalViewHolder( view );
    }

    @Override
    public void onBindViewHolder(HospitalAdapter.HospitalViewHolder holder, int size) {
        HospitalData title = myList.get(size);
        holder.txtTitle.setText(title.getName());
        Log.e("tag","message"+title.getURL());
        Picasso.with(context)
                .load(title.getURL())
                .into(holder.imageHospital);


    }


    @Override
    public int getItemCount() {
        return myList.size();
    }
    public class HospitalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtTitle;
        ImageView imageHospital;
        public HospitalViewHolder(View itemView) {
            super( itemView );
            imageHospital = (ImageView) itemView.findViewById( R.id.imageHospital );
            txtTitle = (TextView) itemView.findViewById( R.id.txtTitle );
            itemView.setOnClickListener(this);

        }



        @Override
        public void onClick(View v) {
            int Position = getAdapterPosition();

            String name = myList.get(Position).getName();
            String Phonenumber = myList.get(Position).getPhonenumber();
            String Address = myList.get(Position).getAddress();
            String URL =myList.get( Position).getURL ();

           // Log.e( "name", ">>>>>>>>"+name);
           // Log.e( "URL", ">>>>>>>>"+URL);

            Intent intent =new Intent(context, hospital.class);

            intent.putExtra("name",name);
            intent.putExtra( "URL",URL );

            intent.putExtra( "Phonenumber",Phonenumber );
            intent.putExtra( "Address",Address );
            context.startActivity(intent);
        }
    }
}

