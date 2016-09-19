package com.lxp.drawerlayoutdemo;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {
    private DrawerLayout mDrawerLayout;
    private ListView mListView;
    private ArrayList<String> menuList;
    private ArrayAdapter<String> adapter;
    private android.support.v4.app.ActionBarDrawerToggle mDrawerToggle;
    private String mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTitle = (String) getActionBar().getTitle();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mListView = (ListView) findViewById(R.id.left_drawer);
        menuList = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            menuList.add("item:" + i);
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menuList);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(this);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActionBar().setTitle("请选择");
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActionBar().setTitle(mTitle);
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //动态插入fragment到FrameLayout
        Fragment fragment = new ContentFragment();
        Bundle args = new Bundle();
        args.putString("text", menuList.get(position));
        fragment.setArguments(args);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_content, fragment).commit();

        mDrawerLayout.closeDrawer(mListView);
    }
}
