package com.example.myapplication.adapter;

import android.content.Context;
import android.text.style.IconMarginSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.models.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BestProductsAdapter extends BaseAdapter {
    List<Product> productList=new ArrayList<>();
    Context context;
    LayoutInflater inflater;

    public BestProductsAdapter(Context context, List<Product> products){
        productList=products;
        this.context=context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Product product=productList.get(position);

        view=inflater.inflate(R.layout.product_row,null);

        TextView txt_title=(TextView)view.findViewById(R.id.txt_title);
        ImageView img_app=(ImageView)view.findViewById(R.id.img_app);

        // txt_title.setText(productList.get(position).getTitle());
        txt_title.setText(product.getTitle());
      //  Picasso.with(context).setLoggingEnabled(true);

        Picasso.with(context)
               .load(product.getIcon()) //Load the image
//               .placeholder(R.drawable.ic_launcher_background) //Image resource that act as placeholder
//              .error(R.drawable.ic_launcher_foreground) //Image resource for error
               .into(img_app); // View where image is loaded.

        return view;
    }
}
