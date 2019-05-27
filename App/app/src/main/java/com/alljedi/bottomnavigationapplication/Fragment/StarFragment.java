package com.alljedi.bottomnavigationapplication.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alljedi.bottomnavigationapplication.Adapter.MyStarRecyclerViewAdapter;
import com.alljedi.bottomnavigationapplication.R;
import com.alljedi.bottomnavigationapplication.Content.StarItemContent.StarItem;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.support.constraint.Constraints.TAG;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class StarFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private String srcUrl = "http://47.103.9.254:3180/paperList/username/get";
    private static final int UPDATE=1;
    private ArrayList<StarItem> starItemArrayList = new ArrayList<>();
    private RecyclerView recyclerView ;
    int flag = 0;
    static private Handler mHandler;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public StarFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static StarFragment newInstance(int columnCount) {
        StarFragment fragment = new StarFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @SuppressLint("HandlerLeak")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case UPDATE:
                        recyclerView.setAdapter(new MyStarRecyclerViewAdapter(starItemArrayList,mListener));
                        break;
                    default:
                        break;
                }
            }
        };
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_star_list, container, false);
        View listView = view.findViewById(R.id.list);
        // Set the adapter
        if (listView instanceof RecyclerView) {
            Context context = listView.getContext();
            recyclerView = (RecyclerView) listView;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            flag = 0;
            getData();
        }
        return view;
    }

    public void getData(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                starItemArrayList.clear();
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url(srcUrl+"?username=test").build();
                try {
                    Response response = client.newCall(request).execute();//发送请求
                    String data = response.body().string();
                    if (data == null){
                        //TODO:
                    }
                    JSONArray res=new JSONArray(data);
                    for(int i=0;i<res.length();i++){
                        JSONObject obj=res.getJSONObject(i);
                        starItemArrayList.add(new StarItem(obj.getString("id"),obj.getString("title"),obj.getString("author"),obj.getString("summary")));
                    }
                    flag=1;
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

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(StarItem item);
    }
}
