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
import com.letsdowebsite.mydelhi.dic;

import java.util.ArrayList;

import model.DelhiData;


public class DicAdapter extends RecyclerView.Adapter<DicAdapter.DicViewHolder>{

    Context context ;
    ArrayList<DelhiData> myList;

   public DicAdapter(Context context, ArrayList<DelhiData> myList) {
        this.myList = myList;
        this.context = context;
        }

    @Override
    public DicAdapter.DicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
        View view = inflater.inflate( R.layout.list_metro3, parent, false );
        return new DicAdapter.DicViewHolder(view);
    }


    public void onBindViewHolder(DicAdapter.DicViewHolder holder, int size)
    {
        DelhiData title = myList.get(size);
        holder.tvSource.setText( title.getSource() );
        holder.tvDistanction.setText( title.getDestination() );

        Log.e("tag","color"+title.getColor());

        holder.tvColor.setBackgroundColor(Color.parseColor(title.getColor()));
    // holder.tvColor.setBackgroundColor( Color.parseColor( title.getColor() ) );
      //  holder.tvColor.setBackgroundColor(Color.parseColor("#303F9F"));
    }



    @Override
    public int getItemCount()
    {
        return myList.size();
    }

    public class DicViewHolder extends RecyclerView.ViewHolder {

        ImageView imgIcon;
        TextView tvDistanction;
        TextView tvSource;
        View tvColor;

        public DicViewHolder(View itemView) {
            super( itemView );
            ImageView imgIcon = (ImageView) itemView.findViewById( R.id.img );
            tvDistanction = (TextView) itemView.findViewById( R.id.tvDistanction);
            tvSource = (TextView) itemView.findViewById( R.id.tvSource);
            tvColor=(View)itemView.findViewById( R.id.tvColor );

        }
        public void onClick(View v) {
            int Position = getAdapterPosition();

            String source = myList.get(Position).getSource();
            String destination  = myList.get(Position).getDestination();
            String color = myList.get(Position).getColor();



            Intent intent = new Intent(context, dic.class);
            intent.putExtra("source",source);
            intent.putExtra( "destination",destination );
            intent.putExtra( "color",color );

            context.startActivity(intent);

        }
    }
}



