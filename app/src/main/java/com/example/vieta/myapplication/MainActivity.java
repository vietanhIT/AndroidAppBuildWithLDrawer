package com.example.vieta.myapplication;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ikimuhendis.ldrawer.ActionBarDrawerToggle;
import com.ikimuhendis.ldrawer.DrawerArrowDrawable;


public class MainActivity extends Activity {
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerArrowDrawable drawerArrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar ac=getActionBar();
        ac.setDisplayHomeAsUpEnabled(true);
        ac.setHomeButtonEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.navdrawer);
        drawerArrow = new DrawerArrowDrawable(this) {
            @Override
            public boolean isLayoutRtl() {
                return false;
            }
        };
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                drawerArrow, R.string.drawer_open,
                R.string.drawer_close) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        String[] values = new String[]{
                "hehe","hihi"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, android.R.id.text1, values);
        mDrawerList.setAdapter(adapter);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                selectItem(position);
            }
        });

        selectItem(0);
    }

    private void selectItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                mDrawerLayout.closeDrawer(mDrawerList);
                //fragment = new FragmentHour();
                Toast.makeText(this,"hehe",Toast.LENGTH_LONG).show();
                break;
            case 1:
                mDrawerLayout.closeDrawer(mDrawerList);
               // fragment = new FragmentToday();
                break;
//            case 2:
//                mDrawerLayout.closeDrawer(mDrawerList);
//                //fragment = new FragmentCity();
//                break;
//            case 3:
//                mDrawerLayout.closeDrawer(mDrawerList);
//                //fragment = new FragmentMap();
//                break;
//            case 4:
//                mDrawerLayout.closeDrawer(mDrawerList);
//                //exit();
//                return;
//            default:
//                mDrawerLayout.closeDrawer(mDrawerList);
//               // fragment = new FragmentToday();
//                break;
        }
//        FragmentManager fragmentManager = getFragmentManager();
//        fragmentManager.beginTransaction()
//                .replace(R.id.frame_layout, fragment)
//                .addToBackStack(null)
//                .commit();
//        mDrawerList.setItemChecked(position, true);
//        mDrawerLayout.closeDrawer(mDrawerList);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                if (mDrawerLayout.isDrawerOpen(mDrawerList)) {
                    mDrawerLayout.closeDrawer(mDrawerList);
                } else {
                    mDrawerLayout.openDrawer(mDrawerList);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
