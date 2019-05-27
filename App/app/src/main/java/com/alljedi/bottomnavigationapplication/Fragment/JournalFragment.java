package com.alljedi.bottomnavigationapplication.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alljedi.bottomnavigationapplication.Adapter.JournalAdapter;
import com.alljedi.bottomnavigationapplication.R;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class JournalFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private String categoriesurl="http://47.103.9.254:3180/periodical/getAll";
    private Handler mHandler;
    ArrayList<String> catelist=new ArrayList<>();
    private int flag=0;
    private static final String TAG ="TEST";
    private static final int UPDATE=1;
    RecyclerView recyclerView;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public JournalFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static JournalFragment newInstance(int columnCount) {
        JournalFragment fragment = new JournalFragment();
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
                        recyclerView.setAdapter(new JournalAdapter(catelist));
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
        View view = inflater.inflate(R.layout.fragment_journal_list, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
//设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper. VERTICAL);
//设置Adapter
        flag=0;
        getdata();
        recyclerView.setItemAnimator( new DefaultItemAnimator());
        return view;
    }

    // @Override
    // public void onAttach(Context context) {
    //     super.onAttach(context);
    //     if (context instanceof OnListFragmentInteractionListener) {
    //         mListener = (OnListFragmentInteractionListener) context;
    //     } else {
    //         throw new RuntimeException(context.toString()
    //                 + " must implement OnListFragmentInteractionListener");
    //     }
    // }

    @Override
    public void onDetach() {
        super.onDetach();
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
    }
    public void sendMessage(int id){
        if (mHandler != null) {
            Message message = Message.obtain(mHandler, id);
            mHandler.sendMessage(message);
        }
    }
    public void getdata(){
        catelist.clear();
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url(categoriesurl).build();
                try {
                    Response response = client.newCall(request).execute();//发送请求
                    String data = response.body().string();
                    String[] temp = data.substring(1,data.length()-1).split(",");
                    for(int i=0;i<temp.length;i++){
                        catelist.add(temp[i].substring(1,temp[i].length()-1));
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
