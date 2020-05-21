package com.example.trackit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class TripListAdapter extends
                RecyclerView.Adapter<TripListAdapter.TripViewHolder>{
    private final LinkedList<String> mTripList;

    private LayoutInflater mInflater;

    public TripListAdapter(Context context, LinkedList<String> tripList) {
        mInflater = LayoutInflater.from(context);
        this.mTripList = tripList;
    }

    @NonNull
    @Override
    public TripListAdapter.TripViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mItemView = mInflater.inflate(R.layout.trip_item, parent, false);

        return new TripViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull TripListAdapter.TripViewHolder holder, int position) {

        String mCurrent = mTripList.get(position);

        holder.tripItemView.setText(mCurrent);

    }

    @Override
    public int getItemCount() {
        return mTripList.size();
    }

    class TripViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        public final TextView tripItemView;
        final TripListAdapter mAdapter;
        public TripViewHolder(View itemView, TripListAdapter adapter) {
            super(itemView);
            tripItemView = itemView.findViewById(R.id.tv_trip);
            this.mAdapter = adapter;
            tripItemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();

            String element = mTripList.get(mPosition);

            mTripList.set(mPosition, "Clicked!! " + element);

            mAdapter.notifyDataSetChanged();
        }
    }
}
