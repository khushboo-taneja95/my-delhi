package com.letsdowebsite.mydelhi.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.letsdowebsite.mydelhi.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import model.FortData;



public class FortAdapter extends RecyclerView.Adapter<FortAdapter.FortViewHolder>{
    Context context ;
    ArrayList<FortData> myList;

    public FortAdapter(Context context, ArrayList<FortData> myList) {
        this.myList = myList;
        this.context = context;
    }

    @Override
    public FortAdapter.FortViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate( R.layout.singleview_fort,parent,false);
        return new FortAdapter.FortViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FortViewHolder holder, int size) {
        FortData title = myList.get(size);
        holder.textView.setText(title.getName());
        Picasso.with(context)
                .load(title.getURL())
                .into(holder.imageIcon);

    }

    @Override
    public int getItemCount() {
        return myList.size();
    }
    public class FortViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageIcon;
       Button button;

        public FortViewHolder(View itemView) {
            super( itemView );
           imageIcon = (ImageView) itemView.findViewById(R.id.imageFort);
            textView = (TextView) itemView.findViewById(R.id.txtTitle);
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
