package com.alljedi.bottomnavigationapplication.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.alljedi.bottomnavigationapplication.Adapter.NormalAdapter;
import com.alljedi.bottomnavigationapplication.DetailActivity;
import com.alljedi.bottomnavigationapplication.MainActivity;
import com.alljedi.bottomnavigationapplication.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class TextFragment extends Fragment {
    private RecyclerView recyclerView;
    private String srcurl="http://47.103.9.254:3180/paper/getAll";
    ArrayList<String> titlelist=new ArrayList<>();
    ArrayList<String> summarylist=new ArrayList<>();
    ArrayList<String> pubtimelist=new ArrayList<>();
    ArrayList<String> authorlist=new ArrayList<>();
    ArrayList<String> sourcelist=new ArrayList<>();
    private int flag=0;
    private static final String TAG ="TEST";
    private static final int UPDATE=1;
    private Handler mHandler;
    private NormalAdapter adapter;
    @SuppressLint("HandlerLeak")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case UPDATE:
                        adapter=new NormalAdapter(titlelist,summarylist,pubtimelist,authorlist,sourcelist);
                        recyclerView.setAdapter(adapter);
                        adapter.setOnItemClickListener(new NormalAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int postion) {
                                Bundle bundle = new Bundle();
                                bundle.putString("title", titlelist.get(postion));
                                bundle.putString("summary",summarylist.get(postion));
                                bundle.putString("author", authorlist.get(postion));
                                bundle.putString("source", sourcelist.get(postion));
                                Intent intent = new Intent();
                                intent.putExtras(bundle);
                                intent.setClass(TextFragment.super.getActivity(), DetailActivity.class);
                                startActivity(intent);
                            }
                        });
                        break;
                    default:
                        break;
                }
            }
        };
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
//设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper. VERTICAL);
//设置Adapter
        flag=0;
        getdata();

        recyclerView.setAdapter(new NormalAdapter(titlelist,summarylist,pubtimelist,authorlist,sourcelist));
        //设置分隔线
        //recyclerView.addItemDecoration( new DividerGridItemDecoration(this ));
//设置增加或删除条目的动画
        recyclerView.setItemAnimator( new DefaultItemAnimator());
        new PagerSnapHelper().attachToRecyclerView(recyclerView);
        return view;
    }
    public void sendMessage(int id){
        if (mHandler != null) {
            Message message = Message.obtain(mHandler, id);
            mHandler.sendMessage(message);
        }
    }
    public void getdata(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url(srcurl).build();
                try {
                    Response response = client.newCall(request).execute();//发送请求
                    String data = response.body().string();
                    JSONArray res=new JSONArray(data);
                    for(int i=0;i<res.length();i++){
                        JSONObject obj=res.getJSONObject(i);
                        String title=obj.getString("title");
                        String summary=obj.getString("summary");
                        String pubTime=obj.getString("pubTime");
                        String author=obj.getString("author");
                        String source=obj.getString("source");
                        titlelist.add(title);
                        summarylist.add(summary);
                        pubtimelist.add(pubTime);
                        authorlist.add(author);
                        sourcelist.add(source);
                    }
                    flag=1;
                    sendMessage(UPDATE);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
