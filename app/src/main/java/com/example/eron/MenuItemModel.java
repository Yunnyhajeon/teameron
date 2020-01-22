package com.example.eron;

public class MenuItemModel {

    /*
    This class represents each of the items in the table of contents. So Head would be an item
    and each of its subsections would be its own item as well

    We are using this class to store info to populate the ExpandableListView

    For example:
    MenuItemModel head = new MenuItemModel("Head", "head_1_headache.html", true, true)
    MenuItemModel head_headache =  new MenuItemModel("Headache", "head_1, headache.html", false, false)
     */

    public String itemName, htmlUrl;
    public boolean isGroup, hasChildren;
    //isGroup = is this item a main section
    //hasChildren = 1) is this item a main section AND 2) does this main section have subsections


    public MenuItemModel(String itemName, String htmlUrl, boolean isGroup, boolean hasChildren) {
        this.itemName = itemName;
        this.htmlUrl = htmlUrl;
        this.isGroup = isGroup;
        this.hasChildren = hasChildren;
    }

}
