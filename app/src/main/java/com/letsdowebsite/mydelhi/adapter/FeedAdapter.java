package com.letsdowebsite.mydelhi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.letsdowebsite.mydelhi.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import model.FeedData;


   public class FeedAdapter  extends RecyclerView.Adapter<FeedAdapter.feedViewHolder> {
       Context context ;
       ArrayList<FeedData> myList;

       public FeedAdapter(Context context, ArrayList<FeedData> myList) {
           this.myList = myList;
           this.context = context;
       }

       @Override
       public FeedAdapter.feedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
           LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
           View view = inflater.inflate( R.layout.singleview_feed, parent, false );
           return new FeedAdapter.feedViewHolder( view );
       }


       public void onBindViewHolder(FeedAdapter.feedViewHolder holder, int size) {
           FeedData title = myList.get(size);
           holder.txtTitle.setText(title.getName());
           Picasso.with(context)
                   .load(title.getURL())
                   .into(holder.imageFeed);
       }



       @Override
       public int getItemCount() {
           return myList.size();
       }

       public class feedViewHolder extends RecyclerView.ViewHolder {

           ImageView imageFeed;
           TextView txtTitle;

           public feedViewHolder(View itemView) {
               super( itemView );
               imageFeed = (ImageView) itemView.findViewById( R.id.imageFeed );
               txtTitle = (TextView) itemView.findViewById( R.id.txtTitle );
               txtTitle=(TextView) itemView.findViewById( R.id.title );

           }
       }
   }

