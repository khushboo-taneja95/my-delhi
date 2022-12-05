package com.letsdowebsite.mydelhi.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import  android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.letsdowebsite.mydelhi.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import model.ListData;


public class ParkAdapter extends RecyclerView.Adapter<ParkAdapter.ParkViewHolder>{

    Context context ;
    ArrayList<ListData> myList;

    public ParkAdapter(Context context, ArrayList<ListData> myList) {
     this.myList = myList;
     this.context = context;
    }

    @Override
    public ParkAdapter.ParkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate( R.layout.singleview_park,parent,false);
        return new ParkAdapter.ParkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ParkViewHolder holder, int size) {
        ListData title = myList.get(size);
        holder.textView.setText(title.getName());
        Picasso.with(context)
                .load(title.getURL())
                .into(holder.imgIcon2);
    }
    @Override
    public int getItemCount() {
        return myList.size();
    }
    public class ParkViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imgIcon2;
        Button button;


        public ParkViewHolder(View itemView) {
            super( itemView );
            imgIcon2 = (ImageView) itemView.findViewById( R.id.imagePark );
            textView= (TextView) itemView.findViewById( R.id.txtTitle2 );
            button =(Button) itemView.findViewById( R.id.button_menu );
            button.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                            Uri.parse("http://maps.google.com/maps?addr=" + "28.6284371" + "," + "77.3779177" + "&daddr=" + "28.644800" + "," + "77.216721"));
                    context.startActivity(intent);
                }
            } );


        }
    }
}
