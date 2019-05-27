package com.alljedi.bottomnavigationapplication.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alljedi.bottomnavigationapplication.Adapter.NormalAdapter;
import com.alljedi.bottomnavigationapplication.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MyFragment extends Fragment {
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    private String srcurl="http://47.103.9.254:3180/periodical/username/get";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private HashMap<String,Integer> map=new HashMap<>();
    public  ArrayList<String> txts=new ArrayList<String>();
    private GridView gridView;
    private static final String TAG ="TEST";
    private static final int UPDATE=1;
    private Handler mHandler;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MyFragment() {

    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static MyFragment newInstance(int columnCount) {
        MyFragment fragment = new MyFragment();
        return fragment;
    }

    @SuppressLint("HandlerLeak")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context=getContext();
        init();
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case UPDATE:
                        gridView.setAdapter(new GridAdapter(context));
                        break;
                    default:
                        break;
                }
            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        gridView=view.findViewById(R.id.gridView);
        // Set the adapter
        getdata();
        return view;
    }
    public void getdata(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url(srcurl+"?username=test").build();
                try {
                    Response response = client.newCall(request).execute();//发送请求
                    String data = response.body().string();
                    JSONArray res=new JSONArray(data);
                    for(int i=0;i<res.length();i++){
                        JSONObject obj=res.getJSONObject(i);
                        String title=obj.getString("source");
                        txts.add(title);
                    }
                    sendMessage(UPDATE);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public void sendMessage(int id){
        if (mHandler != null) {
            Message message = Message.obtain(mHandler, id);
            mHandler.sendMessage(message);
        }
    }
    public class GridAdapter extends BaseAdapter {

        private Context mContext;


        public GridAdapter(Context context) {
            this.mContext = context;
        }


        @Override
        public int getCount() {
            return txts.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            /*DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
                    .cacheInMemory(true)   //内存缓存
                    .cacheOnDisk(true)    //硬盘缓存
                     .build();
            ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this.mContext)
                    .defaultDisplayImageOptions(displayImageOptions)
                    .build();
            ImageLoader.getInstance().init(config);*/

            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_grid, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.itemImg = (ImageView) convertView.findViewById(R.id.iv_head);
                viewHolder.itemtxt = (TextView) convertView.findViewById(R.id.iv_tail);
                //x.image().bind(viewHolder.itemImg,urls.get(position));
                viewHolder.itemtxt.setText(txts.get(position));
                viewHolder.itemImg.setImageResource(map.get(txts.get(position)));
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            //ImageLoader.getInstance().displayImage("http://47.100.107.158/static/marker_radar_g.png",  viewHolder.itemImg);
            convertView.setTag(viewHolder);
            return convertView;
        }


        class ViewHolder {
            ImageView itemImg;
            TextView itemtxt;
            
        }

    }
    public void init(){
        map.clear();
        map.put("世界有色金属",R.drawable.p1);
        map.put("中国医学装备",R.drawable.p2);
        map.put("中国心理卫生杂志",R.drawable.p3);
        map.put("中国机械工程",R.drawable.p4);
        map.put("中国现代应用药学",R.drawable.p5);
        map.put("信息技术",R.drawable.p6);
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
