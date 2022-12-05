package com.letsdowebsite.mydelhi.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.letsdowebsite.mydelhi.R;
import com.letsdowebsite.mydelhi.metro;

import java.util.ArrayList;

import model.MetroData;
public class MetroAdapter extends RecyclerView.Adapter <MetroAdapter.metroViewHolder>{
    Context context ;
    ArrayList<MetroData> myList;

    public MetroAdapter(Context context, ArrayList<MetroData> myList) {
        this.myList = myList;
        this.context = context;
    }


    @Override
    public metroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.delhi,parent,false);
        return new metroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(metroViewHolder holder, int size) {
        MetroData title = myList.get(size);
          holder.tvSource.setText( title.getSource() );
          holder.tvDistanction.setText( title.getDestination() );

         Log.e("tag","color"+title.getColor());

       holder.tvColor.setBackgroundColor(Color.parseColor(title.getColor()));
        //     holder.tvColor.setBackgroundColor( Color.parseColor(title.getColor()));

    }

    @Override
    public int getItemCount()
    {
        return myList.size();
    }

    public class metroViewHolder extends RecyclerView.ViewHolder  {

ImageView imgIcon;

        TextView tvDistanction;
        TextView tvSource;
        View tvColor;
        public metroViewHolder(View itemView) {
            super(itemView);
            imgIcon = (ImageView) itemView.findViewById(R.id.img);
            tvDistanction = (TextView) itemView.findViewById( R.id.tvDistanction);
            tvSource = (TextView) itemView.findViewById( R.id.tvSource);
            tvColor=(View)itemView.findViewById( R.id.tvColor );
          //  itemView.setOnClickListener(this);


        }

        public void onClick(View v) {
            int Position = getAdapterPosition();

            String source = myList.get(Position).getSource();
            String destination  = myList.get(Position).getDestination();
            String color = myList.get(Position).getColor();



            Intent intent = new Intent(context, metro.class);
            intent.putExtra("source",source);
            intent.putExtra( "destination",destination );
            intent.putExtra( "color",color );

            context.startActivity(intent);

        }
    }
}