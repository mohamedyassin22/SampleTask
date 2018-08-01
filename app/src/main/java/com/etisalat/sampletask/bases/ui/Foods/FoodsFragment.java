package com.etisalat.sampletask.bases.ui.Foods;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.etisalat.sampletask.R;
import com.etisalat.sampletask.bases.BaseFragment;
import com.etisalat.sampletask.bases.BasePresenter;

import com.etisalat.sampletask.bases.data.DataRepository;
import com.etisalat.sampletask.bases.data.model.Item;
import com.etisalat.sampletask.bases.ui.MainActivity;
import com.etisalat.sampletask.bases.util.Injection;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * The {@link android.support.v4.app.Fragment} that receives FoodsItems data from its
 * {@link FoodsContract.Presenter} and
 * renders a list of Foods
 */

public class FoodsFragment extends BaseFragment implements FoodsContract.View {
    @BindView(R.id.foods_layout)
    FrameLayout foodsLayout;

    public static FoodsFragment newInstance() {

        return new FoodsFragment();
    }

    @BindView(R.id.rvFoods)
    RecyclerView rvFoods;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tvTime)
    TextView tvTime;




    public static final int STARTING_PAGE_INDEX = 1;

    private FoodsRecyclerAdapter recyclerAdapter;
    private List<Item> menuItem;
    private FoodsContract.Presenter presenter;
    private boolean shouldRefreshFoods;
    Unbinder binder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        menuItem = new ArrayList<>();
        DataRepository dataRepository = Injection.provideDataRepository();
        presenter = new FoodsPresenter(this, dataRepository);
        setRetainInstance(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_foods, container, false);
        binder = ButterKnife.bind(this, view);
      ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
        presenter.getMenuItem(getContext());
        layout = foodsLayout;
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerAdapter = new FoodsRecyclerAdapter(this, menuItem);
        rvFoods.setAdapter(recyclerAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rvFoods.setLayoutManager(linearLayoutManager);


    }

    @Override
    protected BasePresenter setupPresenter() {
        return (BasePresenter) presenter;
    }


    @Override
    public void showMenuItem(List<Item> foodItem,String date) {
        if (shouldRefreshFoods) {
            recyclerAdapter.clear();
            shouldRefreshFoods = false;
        }
        recyclerAdapter.addAll(foodItem);
        tvTime.setText(date);




    }

    private void getMenuItem(int id) {
        presenter.getMenuItem(getContext().getApplicationContext());
    }

    private void refreshFoods() {
        shouldRefreshFoods = true;
        getMenuItem(STARTING_PAGE_INDEX);




    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binder.unbind();
    }
       @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_refresh:
               refreshFoods();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }



}
