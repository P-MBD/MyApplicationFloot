package com.example.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.activity.AppDescriptionActivity;
import com.example.myapplication.databinding.ItemCategoryBinding;
import com.example.myapplication.databinding.ProductRowBinding;
import com.example.myapplication.models.Category;
import com.example.myapplication.models.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    List<Category> categoryList = new ArrayList<>();
    Context context;
    LayoutInflater inflater;


    public CategoryAdapter(Context context, List<Category> categories) {
        categoryList=categories;
        this.context=context;
        inflater=LayoutInflater.from(context);
        // گرفتن لاگ از سایز categoryList
        Log.d("CategoryAdapter", "Category list size: " + categoryList.size());
        // Logging each category's name (assuming there's a 'getName()' method in the Category class)
        for (Category category : categoryList) {
            Log.d("CategoryAdapter", "Category: " + category.getName());
        }
    }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemCategoryBinding binding = ItemCategoryBinding.inflate(inflater, parent, false);
        return new CategoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categoryList.get(position);
        holder.binding.categoryName.setText(category.getName());
        Picasso.with(context).load(category.getIconUrl()).resize(100, 100).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(holder.binding.categoryIcon);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        private final ItemCategoryBinding binding;

        public CategoryViewHolder(ItemCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
