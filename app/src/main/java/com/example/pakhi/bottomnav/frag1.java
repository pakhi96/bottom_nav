package com.example.pakhi.bottomnav;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class frag1 extends Fragment implements AdapterView.OnItemClickListener {
    SelectedListener mCallback;
    public interface SelectedListener {
        public void getArticle();
    }
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity;
        if (context instanceof Activity){
            activity=(Activity) context;
        }

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (SelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement SelectedListener");
        }
    }

    private static final String TAG = "RecyclerViewFragment";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    protected RecyclerView mRecyclerView;
    protected CustomAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected static ArrayList<String> arr=new ArrayList<String>();
    public static frag1 newInstance(ArrayList<String> array) {
        frag1 fragment = new frag1();
        arr=array;
        return fragment;
    }
    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }
    protected LayoutManagerType mCurrentLayoutManagerType;
    public frag1() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v= inflater.inflate(R.layout.fragment_frag1, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycle);
        //mRecyclerView.setHasFixedSize(true);
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mLayoutManager = new LinearLayoutManager(getActivity());
        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);



        if(getArguments()!=null){
            arr=getArguments().getStringArrayList("a");
        }
        mAdapter = new CustomAdapter(arr);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        return v;



    }
    public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }
        mLayoutManager = new LinearLayoutManager(getActivity());
        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save currently selected layout manager.
        savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, mCurrentLayoutManagerType);
        super.onSaveInstanceState(savedInstanceState);
    }

    /*@Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,arr);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);

    }
    */

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getActivity(), "Song selected", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
