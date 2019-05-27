package com.alljedi.bottomnavigationapplication.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alljedi.bottomnavigationapplication.R;

import java.util.HashMap;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * TODO: Replace the implementation with code for your data type.
 */
public class JournalAdapter extends RecyclerView.Adapter<JournalAdapter.VH>{
    //② 创建ViewHolder
    private HashMap<String,Integer> map=new HashMap<>();
    public static class VH extends RecyclerView.ViewHolder{
        public final TextView title;
        public ImageView imageView;
        public VH(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.title);
            imageView=(ImageView)v.findViewById(R.id.iv_head);
        }
    }

    private List<String> titlelist;
    public JournalAdapter(List<String> titlelist) {
        this.titlelist = titlelist;
    }

    //③ 在Adapter中实现3个方法
    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.title.setText(titlelist.get(position));
        //holder.imageView.setImageResource(map.get(titlelist.get(position)));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //item 点击事件
            }
        });
    }

    @Override
    public int getItemCount() {
        return titlelist.size();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        //LayoutInflater.from指定写法
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_journal, parent, false);
        return new VH(v);
    }
    public void init(){
        map.clear();
        map.put("世界有色金属",R.drawable.p1);
        map.put("中国医学装备",R.drawable.p2);
        map.put("中国心理卫生杂志",R.drawable.p3);
        map.put("中国机械工程",R.drawable.p4);
        map.put("中国现代应用药学",R.drawable.p5);
        map.put("中国机械工程",R.drawable.p6);
        map.put("南水北调与水利科技",R.drawable.p7);
        map.put("四川师范大学电子出版社",R.drawable.p8);
        map.put("山东工业技术",R.drawable.p9);
        map.put("指挥信息系统与技术",R.drawable.p10);
        map.put("新媒体研究",R.drawable.p11);
        map.put("海南大学学报",R.drawable.p12);
        map.put("激光与光电子学进展",R.drawable.p13);
        map.put("现代工业经济和信息化",R.drawable.p14);
        map.put("电子技术与软件工程",R.drawable.p15);
        map.put("经营与管理",R.drawable.p16);
        map.put("绿色环保建材",R.drawable.p17);
        map.put("计算机产品与流通",R.drawable.p18);
        map.put("计算机工程",R.drawable.p19);
        map.put("计算机应用",R.drawable.p20);
        map.put("软件学报",R.drawable.p21);
    }
}