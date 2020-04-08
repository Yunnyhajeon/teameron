package com.example.eron;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class CheckedActivity extends AppCompatActivity {

    private TextView Category, Symptom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checked);

        Symptom = findViewById(R.id.child);
        List<String> symptomList = new ArrayList<String>();

        for (int i = 0; i < MyCategoriesExpandableListAdapter.parentItems.size(); i++ ){

            for (int j = 0; j < MyCategoriesExpandableListAdapter.childItems.get(i).size(); j++ ){

                String isChildChecked = MyCategoriesExpandableListAdapter.childItems.get(i).get(j).get(ConstantManager.Parameter.IS_CHECKED);

                if (isChildChecked.equalsIgnoreCase(ConstantManager.CHECK_BOX_CHECKED_TRUE))
                {
                    Symptom.setText(Symptom.getText() + " " + MyCategoriesExpandableListAdapter.childItems.get(i).get(j).get(ConstantManager.Parameter.SUB_CATEGORY_NAME) + ", ");
                   //the line above causes things to break if it's structured wrong but I don't know why..
                    symptomList.add(MyCategoriesExpandableListAdapter.childItems.get(i).get(j).get(ConstantManager.Parameter.SUB_CATEGORY_NAME));
                }

            }

        }
    }
}
