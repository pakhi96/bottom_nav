package com.example.pakhi.bottomnav;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class frag2 extends Fragment {
    OnHeadlineSelectedListener mCallback;
    public interface OnHeadlineSelectedListener {
        public void onArticleSelected(String value);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity;

        if (context instanceof Activity){
            activity=(Activity) context;
        }

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnHeadlineSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    public static frag2 newInstance() {
        frag2 fragment = new frag2();
        return fragment;
    }

    public frag2() {
        // Required empty public constructor
    }


    EditText e;
    Button b;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View Rootview= inflater.inflate(R.layout.fragment_frag2, container, false);
        e=(EditText)Rootview.findViewById(R.id.editText);

        b=(Button)Rootview.findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Bundle b=new Bundle();
//                frag1 f=new frag1();
//                b.putString("a",e.getText().toString());
//                f.setArguments(b);

                mCallback.onArticleSelected(e.getText().toString());
            }
        });
        return  Rootview;

    }
    public void start()
    {
        Toast.makeText(getActivity(), "Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
