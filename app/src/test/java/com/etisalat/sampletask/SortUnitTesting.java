package com.etisalat.sampletask;



import com.etisalat.sampletask.bases.data.model.Item;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class SortUnitTesting {
    List<Item>foodItem;
@Before
    public void setup(){
        foodItem=new ArrayList<>();
        foodItem.add(new Item("meet"));
        foodItem.add(new Item("rice"));
        foodItem.add(new Item("potato"));
    }
    @Test
    public void sortTesting(){
    List<Item>foodsorted=sort(foodItem);
    assertEquals("meet", foodsorted.get(0).getName());
    assertEquals("potato", foodsorted.get(1).getName());
    assertEquals("rice",foodsorted.get(2).getName());


    }
    public List<Item> sort(List<Item>foodsItem){
        Collections.sort(foodsItem, new Comparator<Item>()
        {
            @Override
            public int compare(Item item1, Item item2)
            {
                return item1.getName().compareToIgnoreCase(item2.getName());
            }
        });
        return foodsItem;
    }
}
