package com.example.kanal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kanal.Chanel;
import com.example.kanal.R;

import java.util.ArrayList;
import java.util.List;


public class ChanelAdapter extends RecyclerView.Adapter<ChanelAdapter.MyViewHolder> implements Filterable {

    ArrayList<Chanel> mChannelList;
    LayoutInflater inflater;
    List<Chanel> channelListSearch;
    private OnChannelListener onChannelListener;


    public ChanelAdapter(Context context, ArrayList<Chanel> products, OnChannelListener onChannelListener) {
        inflater = LayoutInflater.from(context);
        this.mChannelList = products;
        this.onChannelListener = onChannelListener;
        this.channelListSearch = new ArrayList<>(products);
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.channel_item_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Chanel selectedChannel = mChannelList.get(position);
        holder.setData(selectedChannel, position);

    }

    @Override
    public int getItemCount() {
        return mChannelList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    final Filter filter = new Filter() {

        //run on background
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            List<Chanel> filteredList = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0){
                filteredList.addAll(channelListSearch);
            }else{

                String filterPatern = charSequence.toString().toLowerCase().trim();

                for(Chanel item : channelListSearch){
                    if(item.getChanelName().toLowerCase().contains(filterPatern)){
                        filteredList.add(item);
                    }
                }

            }

            FilterResults filterResults = new FilterResults();

            filterResults.values = filteredList;
            return filterResults;

        }

        //run on ui
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            mChannelList.clear();
            mChannelList.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };


    public interface OnChannelListener {
        void onClick(View v, int position);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView channelName;
        ImageView channelImage, goto_channel;

        public MyViewHolder(View itemView) {
            super(itemView);
            channelName =  itemView.findViewById(R.id.channel_name);
            channelImage =  itemView.findViewById(R.id.channelImage);
            goto_channel =  itemView.findViewById(R.id.goto_channel);
            goto_channel.setOnClickListener(this);

            itemView.setOnClickListener(this);


        }

        public void setData(Chanel selectedProduct, int position) {

            this.channelName.setText(selectedProduct.getChanelName());
            this.channelImage.setImageResource(selectedProduct.getImageID());
        }

        @Override
        public void onClick(View v) {

            onChannelListener.onClick(itemView, getAdapterPosition());

        }


    }

}

