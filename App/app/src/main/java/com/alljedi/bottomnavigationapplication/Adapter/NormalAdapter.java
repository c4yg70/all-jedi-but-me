package com.alljedi.bottomnavigationapplication.Adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alljedi.bottomnavigationapplication.DetailActivity;
import com.alljedi.bottomnavigationapplication.Fragment.TextFragment;
import com.alljedi.bottomnavigationapplication.MainActivity;
import com.alljedi.bottomnavigationapplication.R;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * TODO: Replace the implementation with code for your data type.
 */
public class NormalAdapter extends RecyclerView.Adapter<NormalAdapter.VH> {
    //② 创建ViewHolder
    private OnItemClickListener mClickListener;

    public interface OnItemClickListener {
        public void onItemClick(View view, int postion);
    }

    public static class VH extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView title;
        public final TextView content;
        public final TextView author;
        public final TextView source;

        public OnItemClickListener mListener;// 声明自定义的接口

        public VH(View v, OnItemClickListener listener) {
            super(v);
            mListener = listener;
            title = (TextView) v.findViewById(R.id.tv_title);
            content = (TextView) v.findViewById(R.id.tv_context);
            author = (TextView) v.findViewById(R.id.author);
            source = (TextView) v.findViewById(R.id.source);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // getpostion()为Viewholder自带的一个方法，用来获取RecyclerView当前的位置，将此作为参数，传出去
            mListener.onItemClick(v, getPosition());
        }


    }

    private List<String> titlelist, summarylist, pubtimelist, authorlist, sourcelist;

    public NormalAdapter(List<String> titlelist, List<String> summarylist, List<String> pubtimelist, List<String> authorlist, List<String> sourcelist) {
        this.titlelist = titlelist;
        this.summarylist = summarylist;
        this.authorlist = authorlist;
        this.pubtimelist = pubtimelist;
        this.sourcelist = sourcelist;
    }

    public NormalAdapter() {
    }

    //③ 在Adapter中实现3个方法
    @Override
    public void onBindViewHolder(final VH holder, int position) {
        holder.title.setText(titlelist.get(position));
        holder.author.setText(authorlist.get(position));
        holder.source.setText(sourcelist.get(position));
        holder.content.setText("   " + summarylist.get(position));
    }

    @Override
    public int getItemCount() {
        return summarylist.size();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        //LayoutInflater.from指定写法
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_page, parent, false);
        return new VH(v, mClickListener);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this. mClickListener= listener;

    }
}