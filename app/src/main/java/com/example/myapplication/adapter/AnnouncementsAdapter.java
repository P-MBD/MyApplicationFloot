package com.example.myapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.models.Product;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementsAdapter extends RecyclerView.Adapter<AnnouncementsAdapter.ViewHolder> {

    private Context context;
    private List<Product> productList= new ArrayList<>();
    LayoutInflater inflater;
    public AnnouncementsAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.slidingimages_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);
        String imageUrl = product.getIcon();

        // Log the URL for debugging
        Log.d("AnnouncementsAdapter", "Loading image from URL: " + imageUrl);
        // Use Picasso to load the image
       // Picasso.with(context).load(product.getIcon()).resize(100, 100).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(holder.imageView);

        Picasso.with(context)
                .load(imageUrl)
                .resize(100, 100) // Adjust size as needed
                .error(R.mipmap.ic_launcher) // Error placeholder
                .placeholder(R.mipmap.ic_launcher) // Placeholder
                .into(holder.imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        // Log success
                        Log.d("AnnouncementsAdapter", "Image loaded successfully");
                    }

                    @Override
                    public void onError() {
                        // Log error
                        Log.e("AnnouncementsAdapter", "Error loading image");
                    }
                });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_slider);
        }
    }
}
