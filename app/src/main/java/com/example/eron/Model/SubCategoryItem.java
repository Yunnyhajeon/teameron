package com.example.eron.Model;

public class SubCategoryItem {
    private String subCategoryName;
    private String isChecked;

    public SubCategoryItem(String checked, String name){
        isChecked = checked;
        subCategoryName = name;

    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(String isChecked) {
        this.isChecked = isChecked;
    }
}