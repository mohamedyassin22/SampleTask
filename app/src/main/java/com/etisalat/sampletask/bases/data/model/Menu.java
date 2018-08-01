package com.etisalat.sampletask.bases.data.model;


import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import java.util.List;

/**
 * Created by MohamedYassin on 7/21/2018.
 */
@Root(name = "menu")
public class Menu {
    @ElementList(inline = true)
    public List<Item>foodItem;


    public List<Item> getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(List<Item> foodItem) {
        this.foodItem = foodItem;
    }
    public Menu(){

    }
}



