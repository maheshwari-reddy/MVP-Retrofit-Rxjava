package com.developer.maheshwari.networkcallusingretrofitandrxjava.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.developer.maheshwari.networkcallusingretrofitandrxjava.R;
import com.developer.maheshwari.networkcallusingretrofitandrxjava.model.GetDataPresenter;
import com.developer.maheshwari.networkcallusingretrofitandrxjava.model.iGetDataView;
import com.developer.maheshwari.networkcallusingretrofitandrxjava.pojo.Data;
import com.developer.maheshwari.networkcallusingretrofitandrxjava.view.adapter.ListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements iGetDataView {

    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;

    private ListAdapter adapter;
    private List<Data> data = new ArrayList<>();
    private GetDataPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initList();
        presenter = new GetDataPresenter(this);
        presenter.fetchData();
    }

    private void initList() {
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListAdapter(data);
        recycler_view.setAdapter(adapter);
    }

    @Override
    public void onSuccess(List<Data> data) {
        this.data.clear();
        this.data.addAll(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }
}
