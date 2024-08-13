package com.example.myapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.BestProductsAdapter;
import com.example.myapplication.adapter.CategoryAdapter;
import com.example.myapplication.adapter.ProductAdapter;
import com.example.myapplication.dataProvider.DataManager;
import com.example.myapplication.models.Category;

import java.util.List;

public class CategoriesFragment extends Fragment {



    public CategoriesFragment() {
        // Required empty public constructor
    }

    DataManager dataManager;

    RecyclerView recycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_categories, container, false);

        recycler = (RecyclerView) view.findViewById(R.id.recycler_view);
        dataManager = new DataManager();

        List<Category> categories = dataManager.getCategories();
        Log.d("CategoriesFragment", "Categories size: " + categories.size());

        CategoryAdapter categoryAdapter = new CategoryAdapter(getActivity(), categories);
        recycler.setAdapter(categoryAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);
        return view;
    }
}