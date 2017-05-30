package com.example.pakhi.bottomnav;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements frag2.OnHeadlineSelectedListener,frag1.SelectedListener {
    ArrayList<String> arr=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.action_item1:
                                selectedFragment = frag1.newInstance(arr);
                                break;
                            case R.id.action_item2:
                                selectedFragment = frag2.newInstance();
                                break;
                            case R.id.action_item3:
                                selectedFragment = frag3.newInstance();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, frag2.newInstance());
        transaction.commit();

    }
    public void onArticleSelected(String value)
    {
//        frag2 articleFrag = (frag2)
//                getSupportFragmentManager().findFragmentById(R.id.frame_layout);
        /*if(articleFrag!=null)
        {
            articleFrag.start();
        }
        else {*/
            arr.add(value);
            frag1 newFragment = new frag1();
            Bundle args = new Bundle();
            args.putStringArrayList("a",arr);
            newFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        //}

    }
    public void getArticle()
    {

    }


}
