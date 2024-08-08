package com.example.myapplication.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.myapplication.R;

import com.example.myapplication.databinding.ProductRowBinding;
import com.example.myapplication.models.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;



public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder_Mohammadi > {
    List<Product> productList = new ArrayList<>();
    Context context;
    LayoutInflater inflater;


    public ProductAdapter(Context context, List<Product> products) {
        productList=products;
        this.context=context;
        inflater=LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ViewHolder_Mohammadi onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ProductRowBinding binding = ProductRowBinding.inflate(inflater, parent, false);
        return new ViewHolder_Mohammadi(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_Mohammadi holder, int position) {
        Product product = productList.get(position);

        Typeface typeface=Typeface.createFromAsset(context.getAssets(),"fonts/BYekan.ttf");
        holder.binding.txtTitle.setTypeface(typeface);

        holder.binding.txtTitle.setText(product.getTitle());
        Picasso.with(context).load(product.getIcon()).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(holder.binding.imgApp);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder_Mohammadi extends RecyclerView.ViewHolder {
        private final ProductRowBinding binding;

        //  ImageView img_app;
        public ViewHolder_Mohammadi(ProductRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


    }
}
