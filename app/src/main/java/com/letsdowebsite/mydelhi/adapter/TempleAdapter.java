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

import model.TempleData;


public class TempleAdapter extends RecyclerView.Adapter<TempleAdapter.TempleViewHolder>{
    Context context ;
    ArrayList<TempleData> myList;

    public TempleAdapter(Context context, ArrayList<TempleData> myList) {
        this.myList = myList;
        this.context = context;
    }
    @Override
    public TempleAdapter.TempleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate( R.layout.singleview_temple,parent,false);
        return new TempleAdapter.TempleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TempleViewHolder holder, int size) {
        TempleData title = myList.get(size);
        holder.textView.setText(title.getName());
        Picasso.with(context)
                .load(title.getURL())
                .into(holder.imageicon);
    }
    @Override
    public int getItemCount()
    {
        return myList.size();
    }
    public class TempleViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageicon;
        Button button;


        public TempleViewHolder(View itemView) {
            super( itemView );
           imageicon  = (ImageView) itemView.findViewById( R.id.imageTemple );
            textView= (TextView) itemView.findViewById( R.id.txtTitle1 );
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
