package com.alljedi.bottomnavigationapplication.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alljedi.bottomnavigationapplication.R;
import com.alljedi.bottomnavigationapplication.Fragment.StarFragment.OnListFragmentInteractionListener;
import com.alljedi.bottomnavigationapplication.Content.StarItemContent.StarItem;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link StarItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyStarRecyclerViewAdapter extends RecyclerView.Adapter<MyStarRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<StarItem> mValues=new ArrayList<StarItem>();
    private final OnListFragmentInteractionListener mListener;

    public MyStarRecyclerViewAdapter(List<StarItem> items,
                                     OnListFragmentInteractionListener listener) {
        mValues.clear();
        mValues.addAll(items);
        mListener = listener;
    }
    public MyStarRecyclerViewAdapter(){
        mListener=null;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_star, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mTitleView.setText(mValues.get(position).title);
        holder.mAuthorView.setText(mValues.get(position).author);
        holder.mSummaryView.setText(mValues.get(position).summary);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTitleView;
        public final TextView mAuthorView;
        public final TextView mSummaryView;
        public StarItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTitleView = (TextView) view.findViewById(R.id.title);
            mAuthorView = (TextView) view.findViewById(R.id.author);
            mSummaryView = (TextView) view.findViewById(R.id.summary);
        }

        @Override
        public String toString() {
            return "ViewHolder{" +
                    "mView=" + mView +
                    ", mTitleView=" + mTitleView +
                    ", mAuthorView=" + mAuthorView +
                    ", mSummaryView=" + mSummaryView +
                    ", mItem=" + mItem +
                    ", itemView=" + itemView +
                    '}';
        }
    }
}
