package com.example.myapplication.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_row, parent, false);
                return new ViewHolder_Mohammadi(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_Mohammadi holder, int position) {

      Product product = productList.get(position);
      holder.txt_title.setText(product.getTitle());
      Picasso.with(context).load(product.getIcon()).error(R.mipmap.ic_launcher).into(holder.img_app);
//        //holder.binding.imgApp
//        holder.binding.txtTitle.setText(product.getTitle());
//        Picasso.with(context).load(product.getIcon()).error(R.mipmap.ic_launcher).into(holder.binding.imgApp);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder_Mohammadi extends RecyclerView.ViewHolder {
       // private final ProductRowBinding binding;
       public TextView txt_title;
       public  ImageView img_app;
        public ViewHolder_Mohammadi(View v) {
            super(v);
            //this.binding = binding;
            txt_title = v.findViewById(R.id.txt_title);
            img_app = v.findViewById(R.id.img_app);
        }


    }
}
