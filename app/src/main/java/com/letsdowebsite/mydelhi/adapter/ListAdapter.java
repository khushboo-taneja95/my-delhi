package com.letsdowebsite.mydelhi.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.letsdowebsite.mydelhi.R;

/**
 * Created by Khushboo on 3/14/2018.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    public String[] data;

    public ListAdapter(String[] Data) {
        this.data = Data;
    }

    @Override
    public ListAdapter.ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from( parent.getContext() );

        View view = inflater.inflate( R.layout.singlelist_metro, parent, false );
        return new ListAdapter.ListViewHolder( view );
    }

    @Override
    public void onBindViewHolder(ListAdapter.ListViewHolder holder, int position) {
        String title = data[position];
        holder.txtTitle.setText( title );


    }


    @Override
    public int getItemCount() {
        return data.length;
    }


    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgIcon;
        TextView txtTitle;

        public ListViewHolder(View itemView) {
            super( itemView );
            ImageView imgIcon = (ImageView) itemView.findViewById( R.id.Imgicon );
            txtTitle = (TextView) itemView.findViewById( R.id.title );

        }
    }

}

