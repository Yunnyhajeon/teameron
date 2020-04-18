package com.example.eron;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Set;


public class tip_symptom_finder extends AppCompatActivity {
    RecyclerView tip_recycler_view;
    List<Tip> tipList;
    private TextView Category, Symptom;
    String tipDir = "Tips";
    HashMap<Integer, List<String>> tipMap = new HashMap<>();
    Toolbar toolbar;

    //@Nullable
    @Override
    public void onCreate(Bundle savedInstanceState) {
        //View view = inflater.inflate(R.layout.tip_symptom_finder1, container, false);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tip_symptom_finder1);

        //Symptom = findViewById(R.id.child);
        List<String> symptomList = new ArrayList<String>();

        for (int i = 0; i < MyCategoriesExpandableListAdapter.parentItems.size(); i++ ){

            for (int j = 0; j < MyCategoriesExpandableListAdapter.childItems.get(i).size(); j++ ){

                String isChildChecked = MyCategoriesExpandableListAdapter.childItems.get(i).get(j).get(ConstantManager.Parameter.IS_CHECKED);

                if (isChildChecked.equalsIgnoreCase(ConstantManager.CHECK_BOX_CHECKED_TRUE))
                {
                    //Symptom.setText(Symptom.getText() + " " + MyCategoriesExpandableListAdapter.childItems.get(i).get(j).get(ConstantManager.Parameter.SUB_CATEGORY_NAME) + ", ");
                    //the line above causes things to break if it's structured wrong but I don't know why..
                    symptomList.add(MyCategoriesExpandableListAdapter.childItems.get(i).get(j).get(ConstantManager.Parameter.SUB_CATEGORY_NAME));
                }

            }

        }

        //Log.d("DEBUGGING", "selected symptoms: " + symptomList.toString());

        List<Integer> tipMapKeys = fillTipMap(symptomList);

        //Log.d("DEBUGGING", "matching numbers: " + tipMapKeys.toString());

        tip_recycler_view = findViewById(R.id.tipView);
        toolbar = findViewById(R.id.tip_header);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        toolbar.inflateMenu(R.menu.home);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.home_icon) {
                    Intent intent = new Intent(tip_symptom_finder.this,MainActivity.class);
                    finish();
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

        initData(tipMapKeys);
        initRecyclerView();
    }

    private void initRecyclerView() {
        TipRecyclerAdapter recyclerAdapter = new TipRecyclerAdapter(tipList);
        tip_recycler_view.setAdapter(recyclerAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        tip_recycler_view.addItemDecoration(dividerItemDecoration);
    }

    private void initData(List<Integer> tipMapKeys) {
        tipList = new ArrayList<>();

        for (Integer key:tipMapKeys) {
            for (String tipFileName:tipMap.get(key)) {
                try {
                    //Log.d("DEBUGGING", "tip file name: " + tipFileName);
                    InputStream tipFile = getAssets().open(tipDir + File.separator + tipFileName);
                    String tipFileString = StreamToString(tipFile); //might pass the html files in string format to next screen
                    Document doc = Jsoup.parse(tipFileString);
                    Elements entire_tip = doc.getElementsByClass("entire_tip");
                    String number = entire_tip.select("div.tip_number").text();
                    //Log.d("DEBUGGING", "tip num: " + number);
                    String tags = doc.select("div[class=symptoms]").text();
                    //Log.d("DEBUGGING", "tip symptoms: " + tags);
                    String tip = entire_tip.select("div.tip_contents").text();
                    //Log.d("DEBUGGING", "tip contents: " + tip);
                    String body = entire_tip.select("div.body_contents").text();
                    //Log.d("DEBUGGING", "body contents: " + body);

                    tipList.add(new Tip (number, tags, tip, body));
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(),"Error parsing files! Please try again",Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    private List<Integer> fillTipMap(List<String> symptomList) {
        try {
            String[] tipFilesNames = getAssets().list(tipDir)
                    ;
            if (tipFilesNames != null) {
                Log.d("DEBUGGING", "tip files are not null!!");
                Log.d("DEBUGGING", "" + tipFilesNames.length);
            } else {
                Toast.makeText(getApplicationContext(),"Error parsing files! Please try again",Toast.LENGTH_LONG).show();
                Log.d("DEBUGGING", "tip files are NULL!!");
                return null;
            }

            for (String tipFileName : tipFilesNames) {
                InputStream tipFile = getAssets().open(tipDir + File.separator + tipFileName);
                String tipFileString = StreamToString(tipFile); //might pass the html files in string format to next screen
                Document doc = Jsoup.parse(tipFileString);
                Elements symptoms = doc.select("div[class=symptoms]");
                String[] symptomsText = symptoms.text().split(",");
                List<String> tipSymptoms = Arrays.asList(symptomsText);

                int numMatches = findMatches(symptomList, tipSymptoms);

                if (numMatches > 0) {
                    if (!tipMap.containsKey(numMatches)) {
                        ArrayList<String> tips = new ArrayList<>();
                        tipMap.put(numMatches, tips);
                    }
                    tipMap.get(numMatches).add(tipFileName);
                } else {
                    Toast.makeText(getApplicationContext(),"No tips match your symptoms, please try again with different symptoms.",Toast.LENGTH_LONG).show();
                }
            }

            List<Integer> tipMapKeys = new ArrayList<>(tipMap.keySet());
            Collections.sort(tipMapKeys, Collections.<Integer>reverseOrder());
            return tipMapKeys;

        } catch (IOException e) {
            Toast.makeText(getApplicationContext(),"Error parsing files! Please try again",Toast.LENGTH_LONG).show();
        }

        return null;
    }

    private int findMatches(List<String> selectedSymptoms, List<String> tipSymptoms) {
        //Log.d("DEBUGGING", "tip symptoms: " + tipSymptoms);

        int matches = 0;
        for (String symptom:selectedSymptoms) {
            for (String tipSymptom:tipSymptoms) {
                if (symptom.equalsIgnoreCase(tipSymptom)) { matches++; }
            }
        }

        return matches;
    }

    private String StreamToString(InputStream in) throws IOException {
        if(in == null) {
            return "";
        }
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } finally {
        }
        return writer.toString();
    }


}
