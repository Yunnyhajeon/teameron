package com.example.eron;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;

import com.example.eron.Model.DataItem;
import com.example.eron.Model.SubCategoryItem;

import java.util.ArrayList;
import java.util.HashMap;

public class SF_activity extends AppCompatActivity {
    private Button btn;
    private ExpandableListView lvCategory;

    private ArrayList<DataItem> arCategory;
    private ArrayList<SubCategoryItem> arSubCategory;
    private ArrayList<ArrayList<SubCategoryItem>> arSubCategoryFinal;

    private ArrayList<HashMap<String, String>> parentItems;
    private ArrayList<ArrayList<HashMap<String, String>>> childItems;
    private MyCategoriesExpandableListAdapter myCategoriesExpandableListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_f_activity);

        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SF_activity.this,CheckedActivity.class);
                startActivity(intent);
            }
        });

        setupReferences();
    }

    private void setupReferences() {

        lvCategory = findViewById(R.id.lvCategory);
        arCategory = new ArrayList<>();
        arSubCategory = new ArrayList<>();
        parentItems = new ArrayList<>();
        childItems = new ArrayList<>();

        DataItem dataItem = new DataItem();
        dataItem.setCategoryId("1");
        dataItem.setCategoryName("Head/Neck");

        arSubCategory = new ArrayList<>();

        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Enlarged neck glands"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Fever"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Headache"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Head injury"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Stiff neck"));

        dataItem.setSubCategory(arSubCategory);
        arCategory.add(dataItem);

        dataItem = new DataItem();
        dataItem.setCategoryId("2");
        dataItem.setCategoryName("Eyes");
        arSubCategory = new ArrayList<>();
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Eye color change"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Red eyes"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Swollen eyes"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Unparallel eyes"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Yellow hue of eyes"));

        dataItem.setSubCategory(arSubCategory);
        arCategory.add(dataItem);

        dataItem = new DataItem();
        dataItem.setCategoryId("3");
        dataItem.setCategoryName("Mouth");
        arSubCategory = new ArrayList<>();
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Abnormal teeth"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Cannot swallow liquids"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Drooling"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Hoarseness"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Mouth coloration"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Red mouth"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Swollen lips"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Swollen tongue"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Unable to open mouth wide"));

        dataItem.setSubCategory(arSubCategory);
        arCategory.add(dataItem);


        dataItem = new DataItem();
        dataItem.setCategoryId("4");
        dataItem.setCategoryName("Speech");
        arSubCategory = new ArrayList<>();
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Abnormal crying"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Baby talk"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Deepening voice"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Difficulty speaking"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Loss of talking"));

        dataItem.setSubCategory(arSubCategory);
        arCategory.add(dataItem);


        dataItem = new DataItem();
        dataItem.setCategoryId("5");
        dataItem.setCategoryName("Respiratory");
        arSubCategory = new ArrayList<>();
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Barking Cough"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Cough"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Difficulty breathing"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Harsh noisy sound when breathing in"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Respiratory infection"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Wheezing"));

        dataItem.setSubCategory(arSubCategory);
        arCategory.add(dataItem);


        dataItem = new DataItem();
        dataItem.setCategoryId("6");
        dataItem.setCategoryName("Torso/Legs/Arms");
        arSubCategory = new ArrayList<>();
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Asymmetrical ribs/back"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Breast development"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Cramping"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Difficulty standing"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Difficulty walking"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Firm mass in belly"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Learning to walk late"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Loss of walking"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Pulling up knees"));

        dataItem.setSubCategory(arSubCategory);
        arCategory.add(dataItem);

        dataItem = new DataItem();
        dataItem.setCategoryId("7");
        dataItem.setCategoryName("Digestion/Bowels");
        arSubCategory = new ArrayList<>();
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Bloody stool"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Bright red/maroon stool"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Constipation"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Dark sticky stools"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Diarrhea"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Vomiting"));

        dataItem.setSubCategory(arSubCategory);
        arCategory.add(dataItem);


        dataItem = new DataItem();
        dataItem.setCategoryId("8");
        dataItem.setCategoryName("Urination");
        arSubCategory = new ArrayList<>();
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Dark urine"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Frequent urination"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Painful urination"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Red or brown urine"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Reduced urine"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Strong urine smell"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Wetting themselves"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Wetting the bed"));

        dataItem.setSubCategory(arSubCategory);
        arCategory.add(dataItem);

        dataItem = new DataItem();
        dataItem.setCategoryId("9");
        dataItem.setCategoryName("Skin/Nail");
        arSubCategory = new ArrayList<>();
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Acne"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Body odor"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Dry skin"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Flat light brown birthmark"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Fragile nails"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Freckling"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Hair growth"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Paleness"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Rash"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Red flat birthmark"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Red peeling skin"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Sparse hair"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Tiny red spots"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Turning blue"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Yellow hue of skin"));

        dataItem.setSubCategory(arSubCategory);
        arCategory.add(dataItem);


        dataItem = new DataItem();
        dataItem.setCategoryId("10");
        dataItem.setCategoryName("Privates");
        arSubCategory = new ArrayList<>();
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Anus coloration"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Menstruation"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Growing Genitalia"));

        dataItem.setSubCategory(arSubCategory);
        arCategory.add(dataItem);


        dataItem = new DataItem();
        dataItem.setCategoryId("11");
        dataItem.setCategoryName("Mental Health");
        arSubCategory = new ArrayList<>();
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Anorexia"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Depression"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Irritability"));

        dataItem.setSubCategory(arSubCategory);
        arCategory.add(dataItem);


        dataItem = new DataItem();
        dataItem.setCategoryId("12");
        dataItem.setCategoryName("Common Symptoms");
        arSubCategory = new ArrayList<>();
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Common cold"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Dehydration"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Drowsiness"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Fatigue"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Flu-like symptoms"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Nausea"));

        dataItem.setSubCategory(arSubCategory);
        arCategory.add(dataItem);


        dataItem = new DataItem();
        dataItem.setCategoryId("13");
        dataItem.setCategoryName("Urgent Symptoms");
        arSubCategory = new ArrayList<>();
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Bone pain"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Fainting"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Falling"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Poison"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Seizure"));

        dataItem.setSubCategory(arSubCategory);
        arCategory.add(dataItem);


        dataItem = new DataItem();
        dataItem.setCategoryId("14");
        dataItem.setCategoryName("Other");
        arSubCategory = new ArrayList<>();
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Convulsions"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Difficult to wake"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Drinking much more than normal"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Losing weight"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Not drinking"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Obesity"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Rapid growth"));
        arSubCategory.add(new SubCategoryItem(ConstantManager.CHECK_BOX_CHECKED_FALSE, "Thumb-sucking"));

        dataItem.setSubCategory(arSubCategory);
        arCategory.add(dataItem);




        Log.d("TAG", "setupReferences: "+arCategory.size());

        for(DataItem data : arCategory){
//                        Log.i("Item id",item.id);
            ArrayList<HashMap<String, String>> childArrayList =new ArrayList<HashMap<String, String>>();
            HashMap<String, String> mapParent = new HashMap<String, String>();

            mapParent.put(ConstantManager.Parameter.CATEGORY_ID,data.getCategoryId());
            mapParent.put(ConstantManager.Parameter.CATEGORY_NAME,data.getCategoryName());

            int countIsChecked = 0;
            for(SubCategoryItem subCategoryItem : data.getSubCategory()) {

                HashMap<String, String> mapChild = new HashMap<String, String>();
                mapChild.put(ConstantManager.Parameter.SUB_ID,subCategoryItem.getSubId());
                mapChild.put(ConstantManager.Parameter.SUB_CATEGORY_NAME,subCategoryItem.getSubCategoryName());
                mapChild.put(ConstantManager.Parameter.CATEGORY_ID,subCategoryItem.getCategoryId());
                mapChild.put(ConstantManager.Parameter.IS_CHECKED,subCategoryItem.getIsChecked());

                if(subCategoryItem.getIsChecked().equalsIgnoreCase(ConstantManager.CHECK_BOX_CHECKED_TRUE)) {

                    countIsChecked++;
                }
                childArrayList.add(mapChild);
            }

            if(countIsChecked == data.getSubCategory().size()) {

                data.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_TRUE);
            }else {
                data.setIsChecked(ConstantManager.CHECK_BOX_CHECKED_FALSE);
            }

            mapParent.put(ConstantManager.Parameter.IS_CHECKED,data.getIsChecked());
            childItems.add(childArrayList);
            parentItems.add(mapParent);

        }

        ConstantManager.parentItems = parentItems;
        ConstantManager.childItems = childItems;

        myCategoriesExpandableListAdapter = new MyCategoriesExpandableListAdapter(this,parentItems,childItems,false);
        lvCategory.setAdapter(myCategoriesExpandableListAdapter);
    }
}
