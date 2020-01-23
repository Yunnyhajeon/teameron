package com.example.eron;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

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

        expandableListView = findViewById(R.id.expandable_list_view);
        prepareMenuData();
        populateExpandableList();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ebook, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

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


        //Example group with children
        MenuItemModel headerItem = new MenuItemModel("Head", "file:///android_asset/part1_bodyparts/Head_1_Headache.html", true, true);
        headerList.add(headerItem);
        List<MenuItemModel> children = new ArrayList<>();
        MenuItemModel childItem = new MenuItemModel("Headache", "file:///android_asset/part1_bodyparts/Head_1_Headache.html", false, false);
        children.add(childItem);
        childItem = new MenuItemModel("Head Injury", "file:///android_asset/part1_bodyparts/Head_2_HeadInjury.html", false, false);
        children.add(childItem);
        childItem = new MenuItemModel("Psychological Problems", "file:///android_asset/part1_bodyparts/Head_1_PsychologicalProblems.html", false, false);
        children.add(childItem);
        childList.put(headerItem, children);

        //Example group w/o child  *notice that for this header item, isGroup=true but hasChildren=false
        headerItem = new MenuItemModel("Pregnancy and Postpregnancy", "file:///android_asset/part3_pregnancy/Pregnancy_and_Postpregnancy.html", true, false);
        headerList.add(headerItem);
        childList.put(headerItem, null); //there is no children list for this headerItem so we put null
        */



        //starting from part 1 - Genitalia - these are in file order - NOT book order
        MenuItemModel headerItem = new MenuItemModel("Genitalia", "file:///android_asset/part1_bodyparts/Genitalia_1_Male", true, true);
        headerList.add(headerItem);
        List<MenuItemModel> children = new ArrayList<>();
        MenuItemModel childItem = new MenuItemModel("Male", "file:///android_asset/part1_bodyparts/Genitalia_1_Male", false, false);
        children.add(childItem);
        childItem = new MenuItemModel("Male and Female", "file:///android_asset/part1_bodyparts/Genitalia_2_Genders", false, false);
        children.add(childItem);
        childItem = new MenuItemModel("Female", "file:///android_asset/part1_bodyparts/Genitalia_3_Female", false, false);
        children.add(childItem);
        childList.put(headerItem, children);

        headerItem = new MenuItemModel("Groin", "file:///android_asset/part1_bodyparts/Groin.html", true, false);
        headerList.add(headerItem);
        childList.put(headerItem, null);

        headerItem = new MenuItemModel("Head", "file:///android_asset/part1_bodyparts/Head_1_Headache.html", true, true);
        headerList.add(headerItem);
        List<MenuItemModel> children1 = new ArrayList<>();
        //there may be a better way but this is my attempt at a quick solution for now since we can't use clear()
        childItem = new MenuItemModel("Headache", "file:///android_asset/part1_bodyparts/Head_1_Headache.html", false, false);
        children1.add(childItem);
        childItem = new MenuItemModel("Head Injury", "file:///android_asset/part1_bodyparts/Head_2_HeadInjury.html", false, false);
        children1.add(childItem);
        childItem = new MenuItemModel("Psychological Problems", "file:///android_asset/part1_bodyparts/Head_1_PsychologicalProblems.html", false, false);
        children1.add(childItem);
        childList.put(headerItem, children1);

        headerItem = new MenuItemModel("Hips, Buttocks, Legs, and Ankles", "file:///android_asset/part1_bodyparts/HBLA_1.html", true, true);
        headerList.add(headerItem);
        List<MenuItemModel> children2 = new ArrayList<>();
        childItem = new MenuItemModel("Hips, Buttocks and Legs", "file:///android_asset/part1_bodyparts/HBLA_1.html", false, false);
        children2.add(childItem);
        childItem = new MenuItemModel("Ankles", "file:///android_asset/part1_bodyparts/HBLA_2.html", false, false);
        children2.add(childItem);
        childList.put(headerItem, children2);

        headerItem = new MenuItemModel("Menstruation (Periods), Menopause, and PMS", "file:///android_asset/part1_bodyparts/Menstruation_1.html", true, true);
        headerList.add(headerItem);
        List<MenuItemModel> children3 = new ArrayList<>();
        childItem = new MenuItemModel("Irregular Periods", "file:///android_asset/part1_bodyparts/Menstruation_1.html", false, false);
        children3.add(childItem);
        childItem = new MenuItemModel("Missed Periods", "file:///android_asset/part1_bodyparts/Menstruation_2.html", false, false);
        children3.add(childItem);
        childItem = new MenuItemModel("Pain and PMS", "file:///android_asset/part1_bodyparts/Menstruation_3.html", false, false);
        children3.add(childItem);
        childItem = new MenuItemModel("Bleeding After Menopause", "file:///android_asset/part1_bodyparts/Menstruation_4.html", false, false);
        children3.add(childItem);
        childList.put(headerItem, children3);

        headerItem = new MenuItemModel("Skin", "file:///android_asset/part1_bodyparts/Skin_1_Bites.html", true, true);
        headerList.add(headerItem);
        List<MenuItemModel> children4 = new ArrayList<>();
        childItem = new MenuItemModel("Bites", "file:///android_asset/part1_bodyparts/Skin_1_Bites.html", false, false);
        children4.add(childItem);
        childItem = new MenuItemModel("Discolorations", "file:///android_asset/part1_bodyparts/Skin_2_Discolorations.html", false, false);
        children4.add(childItem);
        childItem = new MenuItemModel("Freckles, Moles, Bumps, Warts, Lumps, Plaques, and Patches", "file:///android_asset/part1_bodyparts/Skin_3_Freckles, Moles, Bumps, Warts, Lumps, Plaques, and Patches.html", false, false);
        children4.add(childItem);
        childItem = new MenuItemModel("Infections", "file:///android_asset/part1_bodyparts/Skin_4_Infections.html.html", false, false);
        children4.add(childItem);
        childItem = new MenuItemModel("Itchy Skin", "file:///android_asset/part1_bodyparts/Skin_5_Itchy Skin.html", false, false);
        children4.add(childItem);
        childItem = new MenuItemModel("Rashes", "file:///android_asset/part1_bodyparts/Skin_6_Rashes.html", false, false);
        children4.add(childItem);
        childItem = new MenuItemModel("Sores", "file:///android_asset/part1_bodyparts/Skin_7_Sores.html", false, false);
        children4.add(childItem);
        childList.put(headerItem, children4);
        children.clear();

        headerItem = new MenuItemModel("Urine", "file:///android_asset/part1_bodyparts/Urine_1_Appearance.html", true, true);
        headerList.add(headerItem);
        List<MenuItemModel> children5 = new ArrayList<>();
        childItem = new MenuItemModel("Appearance", "file:///android_asset/part1_bodyparts/Urine_1_Appearance.html", false, false);
        children5.add(childItem);
        childItem = new MenuItemModel("Discomfort", "file:///android_asset/part1_bodyparts/Urine_2_Discomfort.html", false, false);
        children5.add(childItem);
        childItem = new MenuItemModel("Frequency", "file:///android_asset/part1_bodyparts/Urine_3_Frequency.html", false, false);
        children5.add(childItem);
        childList.put(headerItem, children5);

        //part 2



        //part 3 - Pregnancy
        headerItem = new MenuItemModel("Pregnancy and Postpregnancy", "file:///android_asset/part3_pregnancy/Pregnancy_and_Postpregnancy.html", true, false);
        headerList.add(headerItem);
        childList.put(headerItem, null);


        //part 4



        //part 5 - Prevention of Error
        headerItem = new MenuItemModel("Prevention of Errors in the Hospital", "file:///android_asset/part3_pregnancy/Prevention_Error.html", true, false);
        headerList.add(headerItem);
        childList.put(headerItem, null);



        //part 5 - Appendices
    }

    private void populateExpandableList() {
        expandableListAdapter = new ExpandableListAdapter(this, headerList, childList);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                if (headerList.get(groupPosition).isGroup) {
                    if (!headerList.get(groupPosition).hasChildren) {
                        WebView webView = v.findViewById(R.id.menu_content_webview);
                        Log.i("URL", headerList.get(groupPosition).htmlUrl);
                        webView.loadUrl(headerList.get(groupPosition).htmlUrl);
                        //onBackPressed();
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
                        WebView webView = v.findViewById(R.id.menu_content_webview);
                        Log.i("URL", headerList.get(groupPosition).htmlUrl);
                        webView.loadUrl(model.htmlUrl);
                        //onBackPressed();
                    }
                }

                return false;
            }
        });
    }
}
