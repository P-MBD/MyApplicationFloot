package com.example.myapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.BestProductsAdapter;
import com.example.myapplication.adapter.ProductAdapter;
import com.example.myapplication.dataProvider.DataManager;


public class HomeFragment extends Fragment {



    public HomeFragment() {
        // Required empty public constructor
    }
    GridView grid_best_products;
    DataManager dataManager;

    RecyclerView recycler_best_sellers;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_home2, container, false);
        grid_best_products = (GridView) view.findViewById(R.id.grid_best_product);
        recycler_best_sellers = (RecyclerView) view.findViewById(R.id.recycler_best_sellers);
        dataManager = new DataManager();
        BestProductsAdapter adapter = new BestProductsAdapter(getActivity(), dataManager.getBestProducts());
        grid_best_products.setAdapter(adapter);

        ProductAdapter productAdapter = new ProductAdapter(getActivity(), dataManager.getNewProducts());
        recycler_best_sellers.setAdapter(productAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recycler_best_sellers.setLayoutManager(layoutManager);
        return view;
    }
}