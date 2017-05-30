package com.example.pakhi.bottomnav;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/**
 * Created by Pakhi on 5/28/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    ArrayList<String> list;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView textView;
        public ViewHolder(View v)
        {
            super(v);
            textView=(TextView) v.findViewById(R.id.textView);
        }
        public TextView getTextView() {
            return textView;
        }
    }
    public CustomAdapter(ArrayList<String> songs)
    {
        list=songs;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.view, viewGroup, false);

        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {


        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.getTextView().setText(list.get(position));
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
}
