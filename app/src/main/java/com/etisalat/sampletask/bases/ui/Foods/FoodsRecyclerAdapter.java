package com.etisalat.sampletask.bases.ui.Foods;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.etisalat.sampletask.R;
import com.etisalat.sampletask.bases.data.model.Item;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * The {@link android.support.v7.widget.RecyclerView.Adapter}that renders
 * and populates each FoodsItem
 * in the Foods list.
 */

public class FoodsRecyclerAdapter extends RecyclerView.Adapter<FoodsRecyclerAdapter.ViewHolder> {
    private List<Item> foodsItem;
    private Fragment fragment;

    public FoodsRecyclerAdapter(Fragment fragment, List<Item> foodsItem) {
        this.fragment = fragment;
        this.foodsItem = foodsItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_food, parent, false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item =foodsItem.get(position);
        holder.tvName.setText(item.getName());
        holder.tvPrice.setText(item.getCost() + "$");
        holder.tvDescription.setText(item.getDescription());

    }

    @Override
    public int getItemCount() {
        return foodsItem.size();
    }
    public void clear(){
        int size = getItemCount();
        foodsItem.clear();
        notifyItemRangeRemoved(0, size);
    }
    public void addAll(List<Item> foodsItem) {
        int prevSize = getItemCount();
        sort(foodsItem);
        this.foodsItem.addAll(foodsItem);
        notifyItemRangeInserted(prevSize, foodsItem.size());
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

    public static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.tvPrice)
        TextView tvPrice;
        @BindView(R.id.tvDescription)
        TextView tvDescription;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
