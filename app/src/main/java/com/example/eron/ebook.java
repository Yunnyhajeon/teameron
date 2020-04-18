package com.example.eron;

import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;


import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.OnApplyWindowInsetsListener;

import android.view.Menu;
import android.view.ViewGroup.MarginLayoutParams;

import android.webkit.WebView;

import android.widget.Button;
import android.widget.ExpandableListView;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.view.View.OnClickListener;




public class ebook extends AppCompatActivity {

    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<MenuItemModel> headerList = new ArrayList<>();
    HashMap<MenuItemModel, List<MenuItemModel>> childList = new HashMap<>();

    private static int _counter = 0;
    private Button _decrease;
    private Button _increase;


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


        WebView myWebView = (WebView) findViewById(R.id.menu_content_webview);
        getcounterpage(_counter);

        _decrease = (Button) findViewById(R.id.button1);
        _increase = (Button) findViewById(R.id.button2);

        _decrease.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                _counter--;
                if (_counter >= 0) {
                    getcounterpage(_counter);
                } else {
                    _counter = 0;
                    getcounterpage(_counter);
                }

            }
        });

        _increase.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                _counter++;
                if (_counter <= 80){
                    getcounterpage(_counter);
                } else {
                    _counter = 80;
                    getcounterpage(_counter);
                }
            }
        });

    }


    /*public void previousView(View v) {
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("file:///android_asset/part1_bodyparts/Head_1_Headache.html");
    }*/

    public void getcounterpage(int _counter){
        WebView myWebView = (WebView) findViewById(R.id.menu_content_webview);
        if (_counter == 0) {
            myWebView.loadUrl("file:///android_asset/appendices/titlepage.html");
        } else if (_counter == 1) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Head_1_Headache.html");
        } else if (_counter == 2) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Head_2_HeadInjury.html");
        } else if (_counter == 3) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Head_3_PsychologicalProblems.html");
        } else if (_counter == 4) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Eyes_1_Eyelids.html");
        } else if (_counter == 5) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Eyes_2_Vision_Abnormalities.html");
        } else if (_counter == 6) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Eyes_3_Eye_Pain.html");
        } else if (_counter == 7) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Ear, Nose, Mouth, Throat, and Neck_1_Ear.html");
        } else if (_counter == 8) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Ear, Nose, Mouth, Throat, and Neck_2_Nose.html");
        } else if (_counter == 9) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Ear, Nose, Mouth, Throat, and Neck_3_Mouth.html");
        } else if (_counter == 10) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Ear, Nose, Mouth, Throat, and Neck_4_Throat.html");
        } else if (_counter == 11) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Ear, Nose, Mouth, Throat, and Neck_5_Neck.html");
        } else if (_counter == 12) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Arms and Hands_1_Armpits.html");
        } else if (_counter == 13) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Arms and Hands_2_Arms.html");
        } else if (_counter == 14) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Arms and Hands_3_Hands.html");
        } else if (_counter == 15) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Arms and Hands_4_Fingers.html");
        } else if (_counter == 16) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Arms and Hands_5_Fingernails.html");
        } else if (_counter == 17) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Breast.html");
        } else if (_counter == 18) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Chest Area_1_Breathing_Difficulties.html");
        } else if (_counter == 19) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Chest Area_2_Cough.html");
        } else if (_counter == 20) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Chest Area_3_Chest Pain and Discomfort.html");
        } else if (_counter == 21) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Chest Area_4_Irregular Heartbeats and Heart Sounds.html");
        } else if (_counter == 22) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Belly, Stomach Area, or Abdomen_1_How to Assess Belly Pain.html");
        } else if (_counter == 23) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Belly, Stomach Area, or Abdomen_2_Indigestion.html");
        } else if (_counter == 24) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Belly, Stomach Area, or Abdomen_3_Belly Pain.html");
        } else if (_counter == 25) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Belly, Stomach Area, or Abdomen_4_Bulges and Swelling in the Belly.html");
        } else if (_counter == 26) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Belly, Stomach Area, or Abdomen_5_Sense of Fullness.html");
        } else if (_counter == 27) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Genitalia_1_Male.html");
        } else if (_counter == 28) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Genitalia_2_Genders.html");
        } else if (_counter == 29) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Genitalia_3_Female.html");
        } else if (_counter == 30) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Bowel Movement_1_Pain.html");
        } else if (_counter == 31) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Bowel Movement_2_Form and Frequency.html");
        } else if (_counter == 32) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Bowel Movement_3_Color.html");
        } else if (_counter == 33) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Urine_1_Appearance.html");
        } else if (_counter == 34) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Urine_2_Discomfort.html");
        } else if (_counter == 35) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Urine_3_Frequency.html");
        } else if (_counter == 36) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Menstruation_1.html");
        } else if (_counter == 37) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Menstruation_2.html");
        } else if (_counter == 38) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Menstruation_3.html");
        } else if (_counter == 39) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Menstruation_4.html");
        } else if (_counter == 40) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Groin.html");
        } else if (_counter == 41) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/HBLA_1.html");
        } else if (_counter == 42) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/HBLA_2.html");
        } else if (_counter == 43) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Skin_1_Bites.html");
        } else if (_counter == 44) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Skin_2_Discolorations.html");
        } else if (_counter == 45) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Skin_3_Freckles, Moles, Bumps, Warts, Lumps, Plaques, and Patches.html");
        } else if (_counter == 46) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Skin_4_Infections.html");
        } else if (_counter == 47) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Skin_5_Itchy Skin.html");
        } else if (_counter == 48) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Skin_6_Rashes.html");
        } else if (_counter == 49) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Skin_7_Sores.html");
        } else if (_counter == 50) {
            myWebView.loadUrl("file:///android_asset/part1_bodyparts/Back_1_Back Pain.html");
        } else if (_counter == 51) {
            myWebView.loadUrl("file:///android_asset/part2_SymptomsAndSigns/Allergic Reactions.html");
        } else if (_counter == 52) {
            myWebView.loadUrl("file:///android_asset/part2_SymptomsAndSigns/Blood And Blood Pressure.html");
        } else if (_counter == 53) {
            myWebView.loadUrl("file:///android_asset/part2_SymptomsAndSigns/Dehydration.html");
        } else if (_counter == 54) {
            myWebView.loadUrl("file:///android_asset/part2_SymptomsAndSigns/Fever.html");
        } else if (_counter == 55) {
            myWebView.loadUrl("file:///android_asset/part2_SymptomsAndSigns/Medication.html");
        } else if (_counter == 56) {
            myWebView.loadUrl("file:///android_asset/part2_SymptomsAndSigns/Passing Out, Loss of Consciousness.html");
        } else if (_counter == 57) {
            myWebView.loadUrl("file:///android_asset/part2_SymptomsAndSigns/Temperature Change.html");
        } else if (_counter == 58) {
            myWebView.loadUrl("file:///android_asset/part2_SymptomsAndSigns/Weakness.html");
        } else if (_counter == 59) {
            myWebView.loadUrl("file:///android_asset/part2_SymptomsAndSigns/Weight Loss.html");
        } else if (_counter == 60) {
            myWebView.loadUrl("file:///android_asset/part3_pregnancy/Pregnancy_and_Postpregnancy.html");
        } else if (_counter == 61) {
            myWebView.loadUrl("file:///android_asset/part4_pediatrics/Head_1_Pediatric_Headache.html");
        } else if (_counter == 62) {
            myWebView.loadUrl("file:///android_asset/part4_pediatrics/Pediatric_PsychologicalProblems.html");
        } else if (_counter == 63) {
            myWebView.loadUrl("file:///android_asset/part4_pediatrics/Pediatric_Eyes.html");
        } else if (_counter == 64) {
            myWebView.loadUrl("file:///android_asset/part4_pediatrics/Pediatric_Throat.html");
        } else if (_counter == 65) {
            myWebView.loadUrl("file:///android_asset/part4_pediatrics/Pediatric_Arms_Hands_Fingers_Nails.html");
        } else if (_counter == 66) {
            myWebView.loadUrl("file:///android_asset/part4_pediatrics/Pediatric_Back.html");
        } else if (_counter == 67) {
            myWebView.loadUrl("file:///android_asset/part4_pediatrics/Pediatric_Chest.html");
        } else if (_counter == 68) {
            myWebView.loadUrl("file:///android_asset/part4_pediatrics/Pediatric_Belly.html");
        } else if (_counter == 69) {
            myWebView.loadUrl("file:///android_asset/part4_pediatrics/Pediatric_Urine.html");
        } else if (_counter == 70) {
            myWebView.loadUrl("file:///android_asset/part4_pediatrics/Pediatric_Bowel_Movement.html");
        } else if (_counter == 71) {
            myWebView.loadUrl("file:///android_asset/part4_pediatrics/Pediatric_Genitalia.html");
        } else if (_counter == 72) {
            myWebView.loadUrl("file:///android_asset/part4_pediatrics/Pediatric_Legs.html");
        } else if (_counter == 73) {
            myWebView.loadUrl("file:///android_asset/part4_pediatrics/Pediatric_Skin_Hair.html");
        } else if (_counter == 74) {
            myWebView.loadUrl("file:///android_asset/part4_pediatrics/Pediatric_Allergic_Reactions.html");
        } else if (_counter == 75) {
            myWebView.loadUrl("file:///android_asset/part4_pediatrics/Pediatric_Miscellaneous.html");
        } else if (_counter == 76) {
            myWebView.loadUrl("file:///android_asset/part5_prevention/Prevention_Error.html");
        } else if (_counter == 77) {
            myWebView.loadUrl("file:///android_asset/appendices/appendixA.html");
        } else if (_counter == 78) {
            myWebView.loadUrl("file:///android_asset/appendices/appendixB.html");
        } else if (_counter == 79) {
            myWebView.loadUrl("file:///android_asset/appendices/appendixC.html");
        } else if (_counter == 80) {
            myWebView.loadUrl("file:///android_asset/appendices/appendixD.html");
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();
        if (id == R.id.home_icon) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
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
        childItem = new MenuItemModel("Psychological Problems", "file:///android_asset/part1_bodyparts/Head_3_PsychologicalProblems.html", false, false);
        children.add(childItem);
        childList.put(headerItem, children);

        //Example group w/o child  *notice that for this header item, isGroup=true but hasChildren=false
        headerItem = new MenuItemModel("Pregnancy and Postpregnancy", "file:///android_asset/part3_pregnancy/Pregnancy_and_Postpregnancy.html", true, false);
        headerList.add(headerItem);
        childList.put(headerItem, null); //there is no children list for this headerItem so we put null

        */


        //Part 1 - Body Specific

        MenuItemModel headerItem = new MenuItemModel("Head", "file:///android_asset/part1_bodyparts/Head_1_Headache.html", true, true);
        headerList.add(headerItem);
        List<MenuItemModel> children1 = new ArrayList<>();
        //there may be a better way but this is my attempt at a quick solution for now since we can't use clear()
        MenuItemModel childItem = new MenuItemModel("Headache", "file:///android_asset/part1_bodyparts/Head_1_Headache.html", false, false);
        children1.add(childItem);
        childItem = new MenuItemModel("Head Injury", "file:///android_asset/part1_bodyparts/Head_2_HeadInjury.html", false, false);
        children1.add(childItem);
        childItem = new MenuItemModel("Psychological Problems", "file:///android_asset/part1_bodyparts/Head_3_PsychologicalProblems.html", false, false);
        children1.add(childItem);
        childList.put(headerItem, children1);

        headerItem = new MenuItemModel("Eyes", "file:///android_asset/part1_bodyparts/Eyes_1_Eyelids.html", true, true);
        headerList.add(headerItem);
        List<MenuItemModel> children2 = new ArrayList<>();
        childItem = new MenuItemModel("Eyelids", "file:///android_asset/part1_bodyparts/Eyes_1_Eyelids.html", false, false);
        children2.add(childItem);
        childItem = new MenuItemModel("Vision Abnormalities", "file:///android_asset/part1_bodyparts/Eyes_2_Vision_Abnormalities.html", false, false);
        children2.add(childItem);
        childItem = new MenuItemModel("Eye Pain", "file:///android_asset/part1_bodyparts/Eyes_3_Eye_Pain.html", false, false);
        children2.add(childItem);
        childList.put(headerItem, children2);

        headerItem = new MenuItemModel("Ear, Nose, Mouth, Throat, and Neck", "file:///android_asset/part1_bodyparts/Ear, Nose, Mouth, Throat, and Neck_1_Ear.html", true, true);
        headerList.add(headerItem);
        List<MenuItemModel> children3 = new ArrayList<>();
        childItem = new MenuItemModel("Ear", "file:///android_asset/part1_bodyparts/Ear, Nose, Mouth, Throat, and Neck_1_Ear.html", false, false);
        children3.add(childItem);
        childItem = new MenuItemModel("Nose", "file:///android_asset/part1_bodyparts/Ear, Nose, Mouth, Throat, and Neck_2_Nose.html", false, false);
        children3.add(childItem);
        childItem = new MenuItemModel("Mouth", "file:///android_asset/part1_bodyparts/Ear, Nose, Mouth, Throat, and Neck_3_Mouth.html", false, false);
        children3.add(childItem);
        childItem = new MenuItemModel("Throat", "file:///android_asset/part1_bodyparts/Ear, Nose, Mouth, Throat, and Neck_4_Throat.html", false, false);
        children3.add(childItem);
        childItem = new MenuItemModel("Neck", "file:///android_asset/part1_bodyparts/Ear, Nose, Mouth, Throat, and Neck_5_Neck.html", false, false);
        children3.add(childItem);
        childList.put(headerItem, children3);

        headerItem = new MenuItemModel("Arms and Hands", "file:///android_asset/part1_bodyparts/Arms and Hands_1_Armpits.html", true, true);
        headerList.add(headerItem);
        List<MenuItemModel> children4 = new ArrayList<>();
        childItem = new MenuItemModel("Armpits", "file:///android_asset/part1_bodyparts/Arms and Hands_1_Armpits.html", false, false);
        children4.add(childItem);
        childItem = new MenuItemModel("Arms", "file:///android_asset/part1_bodyparts/Arms and Hands_2_Arms.html", false, false);
        children4.add(childItem);
        childItem = new MenuItemModel("Hands", "file:///android_asset/part1_bodyparts/Arms and Hands_3_Hands.html", false, false);
        children4.add(childItem);
        childItem = new MenuItemModel("Fingers", "file:///android_asset/part1_bodyparts/Arms and Hands_4_Fingers.html", false, false);
        children4.add(childItem);
        childItem = new MenuItemModel("Fingernails", "file:///android_asset/part1_bodyparts/Arms and Hands_5_Fingernails.html", false, false);
        children4.add(childItem);
        childList.put(headerItem, children4);

        headerItem = new MenuItemModel("Breast", "file:///android_asset/part1_bodyparts/Breast.html", true, false);
        headerList.add(headerItem);
        childList.put(headerItem, null);

        headerItem = new MenuItemModel("Chest Area", "file:///android_asset/part1_bodyparts/Chest Area_1_Breathing_Difficulties.html", true, true);
        headerList.add(headerItem);
        List<MenuItemModel> children5 = new ArrayList<>();
        childItem = new MenuItemModel("Breathing Difficulties", "file:///android_asset/part1_bodyparts/Chest Area_1_Breathing_Difficulties.html", false, false);
        children5.add(childItem);
        childItem = new MenuItemModel("Cough", "file:///android_asset/part1_bodyparts/Chest Area_2_Cough.html", false, false);
        children5.add(childItem);
        childItem = new MenuItemModel("Chest Pain and Discomfort", "file:///android_asset/part1_bodyparts/Chest Area_3_Chest Pain and Discomfort.html", false, false);
        children5.add(childItem);
        childItem = new MenuItemModel("Irregular Heartbeats and Heart Sounds", "file:///android_asset/part1_bodyparts/Chest Area_4_Irregular Heartbeats and Heart Sounds.html", false, false);
        children5.add(childItem);
        childList.put(headerItem, children5);

        headerItem = new MenuItemModel("Belly, Stomach Area, Abdomen", "file:///android_asset/part1_bodyparts/Belly, Stomach Area, or Abdomen_1_How to Assess Belly Pain.html", true, true);
        headerList.add(headerItem);
        List<MenuItemModel> children6 = new ArrayList<>();
        childItem = new MenuItemModel("How to Assess Belly Pain", "file:///android_asset/part1_bodyparts/Belly, Stomach Area, or Abdomen_1_How to Assess Belly Pain.html", false, false);
        children6.add(childItem);
        childItem = new MenuItemModel("Indigestion", "file:///android_asset/part1_bodyparts/Belly, Stomach Area, or Abdomen_2_Indigestion.html", false, false);
        children6.add(childItem);
        childItem = new MenuItemModel("Belly Pain", "file:///android_asset/part1_bodyparts/Belly, Stomach Area, or Abdomen_3_Belly Pain.html", false, false);
        children6.add(childItem);
        childItem = new MenuItemModel("Bulges and Swelling in the Belly", "file:///android_asset/part1_bodyparts/Belly, Stomach Area, or Abdomen_4_Bulges and Swelling in the Belly.html", false, false);
        children6.add(childItem);
        childItem = new MenuItemModel("Sense of Fullness", "file:///android_asset/part1_bodyparts/Belly, Stomach Area, or Abdomen_5_Sense of Fullness.html", false, false);
        children6.add(childItem);
        childList.put(headerItem, children6);

        headerItem = new MenuItemModel("Genitalia", "file:///android_asset/part1_bodyparts/Genitalia_1_Male.html", true, true);
        headerList.add(headerItem);
        List<MenuItemModel> children7 = new ArrayList<>();
        childItem = new MenuItemModel("Male", "file:///android_asset/part1_bodyparts/Genitalia_1_Male.html", false, false);
        children7.add(childItem);
        childItem = new MenuItemModel("Male and Female", "file:///android_asset/part1_bodyparts/Genitalia_2_Genders.html", false, false);
        children7.add(childItem);
        childItem = new MenuItemModel("Female", "file:///android_asset/part1_bodyparts/Genitalia_3_Female.html", false, false);
        children7.add(childItem);
        childList.put(headerItem, children7);

        headerItem = new MenuItemModel("Bowel Movement", "file:///android_asset/part1_bodyparts/Bowel Movement_1_Pain.html", true, true);
        headerList.add(headerItem);
        List<MenuItemModel> children8 = new ArrayList<>();
        childItem = new MenuItemModel("Pain", "file:///android_asset/part1_bodyparts/Bowel Movement_1_Pain.html", false, false);
        children8.add(childItem);
        childItem = new MenuItemModel("Form and Frequency", "file:///android_asset/part1_bodyparts/Bowel Movement_2_Form and Frequency.html", false, false);
        children8.add(childItem);
        childItem = new MenuItemModel("Color", "file:///android_asset/part1_bodyparts/Bowel Movement_3_Color.html", false, false);
        children8.add(childItem);
        childList.put(headerItem, children8);

        headerItem = new MenuItemModel("Urine", "file:///android_asset/part1_bodyparts/Urine_1_Appearance.html", true, true);
        headerList.add(headerItem);
        List<MenuItemModel> children9 = new ArrayList<>();
        childItem = new MenuItemModel("Appearance", "file:///android_asset/part1_bodyparts/Urine_1_Appearance.html", false, false);
        children9.add(childItem);
        childItem = new MenuItemModel("Discomfort", "file:///android_asset/part1_bodyparts/Urine_2_Discomfort.html", false, false);
        children9.add(childItem);
        childItem = new MenuItemModel("Frequency", "file:///android_asset/part1_bodyparts/Urine_3_Frequency.html", false, false);
        children9.add(childItem);
        childList.put(headerItem, children9);

        headerItem = new MenuItemModel("Menstruation (Periods), Menopause, and PMS", "file:///android_asset/part1_bodyparts/Menstruation_1.html", true, true);
        headerList.add(headerItem);
        List<MenuItemModel> children10 = new ArrayList<>();
        childItem = new MenuItemModel("Irregular Periods", "file:///android_asset/part1_bodyparts/Menstruation_1.html", false, false);
        children10.add(childItem);
        childItem = new MenuItemModel("Missed Periods", "file:///android_asset/part1_bodyparts/Menstruation_2.html", false, false);
        children10.add(childItem);
        childItem = new MenuItemModel("Pain and PMS", "file:///android_asset/part1_bodyparts/Menstruation_3.html", false, false);
        children10.add(childItem);
        childItem = new MenuItemModel("Bleeding After Menopause", "file:///android_asset/part1_bodyparts/Menstruation_4.html", false, false);
        children10.add(childItem);
        childList.put(headerItem, children10);

        headerItem = new MenuItemModel("Groin", "file:///android_asset/part1_bodyparts/Groin.html", true, false);
        headerList.add(headerItem);
        childList.put(headerItem, null);

        headerItem = new MenuItemModel("Hips, Buttocks, Legs, and Ankles", "file:///android_asset/part1_bodyparts/HBLA_1.html", true, true);
        headerList.add(headerItem);
        List<MenuItemModel> children11 = new ArrayList<>();
        childItem = new MenuItemModel("Hips, Buttocks and Legs", "file:///android_asset/part1_bodyparts/HBLA_1.html", false, false);
        children11.add(childItem);
        childItem = new MenuItemModel("Ankles", "file:///android_asset/part1_bodyparts/HBLA_2.html", false, false);
        children11.add(childItem);
        childList.put(headerItem, children11);

        headerItem = new MenuItemModel("Skin", "file:///android_asset/part1_bodyparts/Skin_1_Bites.html", true, true);
        headerList.add(headerItem);
        List<MenuItemModel> children12 = new ArrayList<>();
        childItem = new MenuItemModel("Bites", "file:///android_asset/part1_bodyparts/Skin_1_Bites.html", false, false);
        children12.add(childItem);
        childItem = new MenuItemModel("Discolorations", "file:///android_asset/part1_bodyparts/Skin_2_Discolorations.html", false, false);
        children12.add(childItem);
        childItem = new MenuItemModel("Freckles, Moles, Bumps, Warts, Lumps, Plaques, and Patches", "file:///android_asset/part1_bodyparts/Skin_3_Freckles, Moles, Bumps, Warts, Lumps, Plaques, and Patches.html", false, false);
        children12.add(childItem);
        childItem = new MenuItemModel("Infections", "file:///android_asset/part1_bodyparts/Skin_4_Infections.html", false, false);
        children12.add(childItem);
        childItem = new MenuItemModel("Itchy Skin", "file:///android_asset/part1_bodyparts/Skin_5_Itchy Skin.html", false, false);
        children12.add(childItem);
        childItem = new MenuItemModel("Rashes", "file:///android_asset/part1_bodyparts/Skin_6_Rashes.html", false, false);
        children12.add(childItem);
        childItem = new MenuItemModel("Sores", "file:///android_asset/part1_bodyparts/Skin_7_Sores.html", false, false);
        children12.add(childItem);
        childList.put(headerItem, children12);

        headerItem = new MenuItemModel("Back", "file:///android_asset/part1_bodyparts/Back_1_Back Pain.html", true, true);
        headerList.add(headerItem);
        List<MenuItemModel> children13 = new ArrayList<>();
        childItem = new MenuItemModel("Back Pain", "file:///android_asset/part1_bodyparts/Back_1_Back Pain.html", false, false);
        children13.add(childItem);
        childList.put(headerItem, children13); //comment


        //Part 2 - Symptoms and Signs
        headerItem = new MenuItemModel("Symptoms And Signs", "file:///android_asset/part2_SymptomsAndSigns/Allergic Reactions.html", true, true);
        headerList.add(headerItem);
        List<MenuItemModel> children14 = new ArrayList<>();
        childItem = new MenuItemModel("Allergic Reactions", "file:///android_asset/part2_SymptomsAndSigns/Allergic Reactions.html", false, false);
        children14.add(childItem);
        childItem = new MenuItemModel("Blood And Blood Pressure", "file:///android_asset/part2_SymptomsAndSigns/Blood And Blood Pressure.html", false, false);
        children14.add(childItem);
        childItem = new MenuItemModel("Dehydration", "file:///android_asset/part2_SymptomsAndSigns/Dehydration.html", false, false);
        children14.add(childItem);
        childItem = new MenuItemModel("Fever", "file:///android_asset/part2_SymptomsAndSigns/Fever.html", false, false);
        children14.add(childItem);
        childItem = new MenuItemModel("Medication", "file:///android_asset/part2_SymptomsAndSigns/Medication.html", false, false);
        children14.add(childItem);
        childItem = new MenuItemModel("Passing Out, Loss of Consciousness", "file:///android_asset/part2_SymptomsAndSigns/Passing Out, Loss of Consciousness.html", false, false);
        children14.add(childItem);
        childItem = new MenuItemModel("Temperature Change", "file:///android_asset/part2_SymptomsAndSigns/Temperature Change.html", false, false);
        children14.add(childItem);
        childItem = new MenuItemModel("Weakness", "file:///android_asset/part2_SymptomsAndSigns/Weakness.html", false, false);
        children14.add(childItem);
        childItem = new MenuItemModel("Weight Loss", "file:///android_asset/part2_SymptomsAndSigns/Weight Loss.html", false, false);
        children14.add(childItem);
        childList.put(headerItem, children14);

        //Part 3 - Pregnancy
        headerItem = new MenuItemModel("Pregnancy and Postpregnancy", "file:///android_asset/part3_pregnancy/Pregnancy_and_Postpregnancy.html", true, false);
        headerList.add(headerItem);
        childList.put(headerItem, null);


        //Part 4 - Pediatrics
        headerItem = new MenuItemModel("Pediatrics", "file:///android_asset/part4_pediatrics/Head_1_Pediatric_Headache.html", true, true);
        headerList.add(headerItem);
        List<MenuItemModel> children15 = new ArrayList<>();
        childItem = new MenuItemModel("Headache", "file:///android_asset/part4_pediatrics/Head_1_Pediatric_Headache.html", true, false);
        children15.add(childItem);
        childItem = new MenuItemModel("Psychological Problems", "file:///android_asset/part4_pediatrics/Pediatric_PsychologicalProblems.html", true, false);
        children15.add(childItem);
        childItem = new MenuItemModel("Eyes", "file:///android_asset/part4_pediatrics/Pediatric_Eyes.html", true, false);
        children15.add(childItem);
        childItem = new MenuItemModel("Throat", "file:///android_asset/part4_pediatrics/Pediatric_Throat.html", true, false);
        children15.add(childItem);
        childItem = new MenuItemModel("Arms, Hands, Fingers, and Nails", "file:///android_asset/part4_pediatrics/Pediatric_Arms_Hands_Fingers_Nails.html", true, false);
        children15.add(childItem);
        childItem = new MenuItemModel("Back", "file:///android_asset/part4_pediatrics/Pediatric_Back.html", true, false);
        children15.add(childItem);
        childItem = new MenuItemModel("Chest", "file:///android_asset/part4_pediatrics/Pediatric_Chest.html", true, false);
        children15.add(childItem);
        childItem = new MenuItemModel("Belly", "file:///android_asset/part4_pediatrics/Pediatric_Belly.html", true, false);
        children15.add(childItem);
        childItem = new MenuItemModel("Urine", "file:///android_asset/part4_pediatrics/Pediatric_Urine.html", true, false);
        children15.add(childItem);
        childItem = new MenuItemModel("Bowel Movements", "file:///android_asset/part4_pediatrics/Pediatric_Bowel_Movement.html", true, false);
        children15.add(childItem);
        childItem = new MenuItemModel("Genitalia", "file:///android_asset/part4_pediatrics/Pediatric_Genitalia.html", true, false);
        children15.add(childItem);
        childItem = new MenuItemModel("Legs", "file:///android_asset/part4_pediatrics/Pediatric_Legs.html", true, false);
        children15.add(childItem);
        childItem = new MenuItemModel("Skin and Hair", "file:///android_asset/part4_pediatrics/Pediatric_Skin_Hair.html", true, false);
        children15.add(childItem);
        childItem = new MenuItemModel("Allergic Reactions", "file:///android_asset/part4_pediatrics/Pediatric_Allergic_Reactions.html", true, false);
        children15.add(childItem);
        childItem = new MenuItemModel("Miscellaneous", "file:///android_asset/part4_pediatrics/Pediatric_Miscellaneous.html", true, false);
        children15.add(childItem);
        childList.put(headerItem, children15);

        //Part 5 - Prevention of Error
        headerItem = new MenuItemModel("Prevention of Errors in the Hospital", "file:///android_asset/part5_prevention/Prevention_Error.html", true, false);
        headerList.add(headerItem);
        childList.put(headerItem, null);



        //Part 5 - Appendices
        headerItem = new MenuItemModel("Appendices", "file:///android_asset/appendices/", true, true);
        headerList.add(headerItem);
        List<MenuItemModel> children0 = new ArrayList<>();
        childItem = new MenuItemModel("Emergency Medical Treatment", "file:///android_asset/appendices/appendixA.html", false, false);
        children0.add(childItem);
        childItem = new MenuItemModel("Self-Examinations", "file:///android_asset/appendices/appendixB.html", false, false);
        children0.add(childItem);
        childItem = new MenuItemModel("Valuable Preventive Screenings", "file:///android_asset/appendices/appendixC.html", false, false);
        children0.add(childItem);
        childItem = new MenuItemModel("Taking a Child's Temperature", "file:///android_asset/appendices/appendixD.html", false, false);
        children0.add(childItem);
        childList.put(headerItem, children0);
    }


    private void setOnClick(final Button btn, final int p){
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                WebView webView = (WebView) findViewById(R.id.menu_content_webview);
                webView.loadUrl(headerList.get(p).htmlUrl);
                // Do whatever you want(str can be used here)

            }
        });
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
                            if (groupPosition == 0){
                                _counter = 1;
                            }else if (groupPosition == 1) {
                                _counter = 4;
                            }else if (groupPosition == 2){
                                _counter = 7;
                            }else if (groupPosition == 3) {
                                _counter = 12;
                            }else if (groupPosition == 4){
                                _counter = 17;
                            }else if (groupPosition == 5) {
                                _counter = 18;
                            }else if (groupPosition == 6){
                                _counter = 22;
                            }else if (groupPosition == 7) {
                                _counter = 27;
                            }else if (groupPosition == 8){
                                _counter = 30;
                            }else if (groupPosition == 9) {
                                _counter = 33;
                            }else if (groupPosition == 10){
                                _counter = 36;
                            }else if (groupPosition == 11) {
                                _counter = 40;
                            }else if (groupPosition == 12){
                                _counter = 41;
                            }else if (groupPosition == 13) {
                                _counter = 43;
                            }else if (groupPosition == 14){
                                _counter = 50;
                            }else if (groupPosition == 15) {
                                _counter = 51;
                            }else if (groupPosition == 16){
                                _counter = 60;
                            }else if (groupPosition == 17) {
                                _counter = 61;
                            }else if (groupPosition == 18){
                                _counter = 76;
                            }else if (groupPosition == 19) {
                                _counter = 77;
                            }

                            Log.i("URL", headerList.get(groupPosition).htmlUrl);
                            webView.loadUrl(headerList.get(groupPosition).htmlUrl);
                            LinearLayout myLayout = (LinearLayout) findViewById(R.id.cover);

                            for ( int i = 0; i < myLayout.getChildCount();  i++ ){
                                View view = myLayout.getChildAt(i);
                                view.setVisibility(View.GONE);
                            }
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
                        parent.collapseGroup(groupPosition);
                        DrawerLayout drawer = findViewById(R.id.drawer_layout);
                        drawer.closeDrawer(GravityCompat.START, false);
                        WebView webView = (WebView) findViewById(R.id.menu_content_webview);

                        if (webView == null) {
                            Log.i("WebViewNullCheck", "WebView is NULL!!!");
                        } else {
                            if (groupPosition == 0){
                                _counter = 1+childPosition;
                            }else if (groupPosition == 1) {
                                _counter = 4+childPosition;
                            }else if (groupPosition == 2){
                                _counter = 7+childPosition;
                            }else if (groupPosition == 3) {
                                _counter = 12+childPosition;
                            }else if (groupPosition == 4){
                                _counter = 17+childPosition;
                            }else if (groupPosition == 5) {
                                _counter = 18+childPosition;
                            }else if (groupPosition == 6){
                                _counter = 22+childPosition;
                            }else if (groupPosition == 7) {
                                _counter = 27+childPosition;
                            }else if (groupPosition == 8){
                                _counter = 30+childPosition;
                            }else if (groupPosition == 9) {
                                _counter = 33+childPosition;
                            }else if (groupPosition == 10){
                                _counter = 36+childPosition;
                            }else if (groupPosition == 11) {
                                _counter = 40+childPosition;
                            }else if (groupPosition == 12){
                                _counter = 41+childPosition;
                            }else if (groupPosition == 13) {
                                _counter = 43+childPosition;
                            }else if (groupPosition == 14){
                                _counter = 50+childPosition;
                            }else if (groupPosition == 15) {
                                _counter = 51+childPosition;
                            }else if (groupPosition == 16){
                                _counter = 60+childPosition;
                            }else if (groupPosition == 17) {
                                _counter = 61+childPosition;
                            }else if (groupPosition == 18){
                                _counter = 76+childPosition;
                            }else if (groupPosition == 19) {
                                _counter = 77+childPosition;
                            }
                            Log.i("URL", headerList.get(groupPosition).htmlUrl);
                            webView.loadUrl(model.htmlUrl);
                            LinearLayout myLayout = (LinearLayout) findViewById(R.id.cover);

                            for (int i = 0; i < myLayout.getChildCount(); i++ ){
                                View view = myLayout.getChildAt(i);
                                view.setVisibility(View.GONE);
                            }
                            //onBackPressed();
                        }

                    }
                }

                return false;
            }
        });
    }
}
