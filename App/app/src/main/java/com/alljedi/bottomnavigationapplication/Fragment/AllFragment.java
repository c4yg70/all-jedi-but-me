package com.alljedi.bottomnavigationapplication.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alljedi.bottomnavigationapplication.R;

import java.util.ArrayList;

public class AllFragment extends Fragment {
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    public ArrayList<String> urls=new ArrayList<String>();
    public  ArrayList<String> txts=new ArrayList<String>();

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public AllFragment() {
        urls.add("http://47.100.107.158:8080/static/marker_radar_g.png");
        urls.add("http://47.100.107.158:8080/static/marker_radar_r.png");
        txts.add("marker_radar_g.png");
        txts.add("marker_radar_r.png");
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static AllFragment newInstance(int columnCount) {
        AllFragment fragment = new AllFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all, container, false);


        return view;
    }

}
