package com.example.eron;

import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

import android.webkit.WebView;

import android.widget.ExpandableListView;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ebook extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<MenuItemModel> headerList = new ArrayList<>();
    HashMap<MenuItemModel, List<MenuItemModel>> childList = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Red Light Warning Signals");

        expandableListView = findViewById(R.id.expandable_list_view);
        prepareMenuData();
        populateExpandableList();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        /*
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_discove_more, R.id.nav_table_of_contents,
                R.id.nav_HEADS, R.id.nav_ear_nose_throat_neck, R.id.arms_and_hands)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

         */
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        /*
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
         */

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.settings_menu, menu);
        return true;
    }

    /*
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

     */

    /*
    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }
    */


    private void prepareMenuData() {
        /*
        purpose of this function is to make
        MenuItemModel instances (headerItem for main sections, childrenItem for subsections)
        and add them to the right list so that we can use the lists to populate the menu

        2)make headerItem and add to the headerList
        3)make childItem and add childItem to children(ArrayList)
        4)insert headerItem and children(ArrayList) (if the header has children, otherwise null) into the childList hashmap

        !!!PLEASE DO THE SECTIONS IN ORDER!!!
        THIS WILL BE THE ORDER IN THE NAVIGATION VIEW
        */

        //Example group with children
        MenuItemModel headerItem = new MenuItemModel("Head", "file:///android_asset/part1_bodyparts/Head_1_Headache.html", true, true);
        headerList.add(headerItem);
        List<MenuItemModel> children = new ArrayList<>();
        MenuItemModel childItem = new MenuItemModel("Headache", "file:///android_asset/part1_bodyparts/Head_1_Headache.html", false, false);
        children.add(childItem);
        childItem = new MenuItemModel("Head Injury", "file:///android_asset/part1_bodyparts/Head_2_HeadInjury.html", false, false);
        children.add(childItem);
        childItem = new MenuItemModel("Psychological Problems", "file:///android_asset/part1_bodyparts/Head_3_PsychologicalProblems.html", false, false);
        children.add(childItem);
        childList.put(headerItem, children);

        //Example group w/o child  *notice that for this header item, isGroup=true but hasChildren=false
        headerItem = new MenuItemModel("Pregnancy and Postpregnancy", "file:///android_asset/part3_pregnancy/Pregnancy_and_Postpregnancy.html", true, false);
        headerList.add(headerItem);
        childList.put(headerItem, null); //there is no children list for this headerItem so we put null
    }

    private void populateExpandableList() {
        expandableListAdapter = new ExpandableListAdapter(this, headerList, childList);
        expandableListView.setAdapter(expandableListAdapter);


        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                if (headerList.get(groupPosition).isGroup) {
                    if (!headerList.get(groupPosition).hasChildren) {
                        //setContentView(R.layout.menu_item_content);
                        DrawerLayout drawer = findViewById(R.id.drawer_layout);
                        drawer.closeDrawer(GravityCompat.START, false);
                        WebView webView = (WebView) findViewById(R.id.menu_content_webview);

                        if (webView == null) {
                            Log.i("WebViewNullCheck", "WebView is NULL!!!");
                        } else {
                            Log.i("URL", headerList.get(groupPosition).htmlUrl);
                            webView.loadUrl(headerList.get(groupPosition).htmlUrl);
                            //onBackPressed();
                        }
                    }
                }

                return false;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                if (childList.get(headerList.get(groupPosition)) != null) {
                    MenuItemModel model = childList.get(headerList.get(groupPosition)).get(childPosition);
                    if (model.htmlUrl.length() > 0) {
                        //setContentView(R.layout.menu_item_content);
                        DrawerLayout drawer = findViewById(R.id.drawer_layout);
                        drawer.closeDrawer(GravityCompat.START, false);
                        WebView webView = (WebView) findViewById(R.id.menu_content_webview);

                        if (webView == null) {
                            Log.i("WebViewNullCheck", "WebView is NULL!!!");
                        } else {
                            Log.i("URL", headerList.get(groupPosition).htmlUrl);
                            webView.loadUrl(model.htmlUrl);
                            //onBackPressed();
                        }

                    }
                }

                return false;
            }
        });
    }
}
