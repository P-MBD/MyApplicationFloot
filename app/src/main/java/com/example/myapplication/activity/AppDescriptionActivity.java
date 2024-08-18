package com.example.myapplication.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.R;
import com.example.myapplication.adapter.ViewPagerListAdapter;
import com.example.myapplication.fragment.CommentsFragment;
import com.example.myapplication.fragment.DetailsFragment;
import com.example.myapplication.fragment.RelatedFragment;
import com.example.myapplication.models.Product;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

public class AppDescriptionActivity extends AppCompatActivity {
    Bundle bundle;

    String title;
    int id;
    Product product;
    ImageView img_app;
    TextView txt_title;
    RatingBar rate_app;
    ViewPager pager;
    TabLayout tabs;
    Button btn_map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_description);
        img_app=(ImageView)findViewById(R.id.img_app);
        txt_title= (TextView) findViewById(R.id.txt_title);
        rate_app = (RatingBar) findViewById(R.id.rate_app);
        pager = (ViewPager) findViewById(R.id.pager);
        tabs = (TabLayout) findViewById(R.id.tabs);
        bundle=getIntent().getExtras();

        if(bundle!=null){
            id=bundle.getInt("id");
            title=bundle.getString("title");
            product = bundle.getParcelable("product");
            txt_title.setText(product.getTitle());
            Picasso.with(getApplicationContext()).load(product.getIcon()).error(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(img_app);

            rate_app.setRating(product.getRate());
        }
        ViewPagerListAdapter viewPagerListAdapter = new ViewPagerListAdapter(getSupportFragmentManager());
        viewPagerListAdapter.addTab(new DetailsFragment(),getResources().getString(R.string.details));
        viewPagerListAdapter.addTab(new CommentsFragment(),getResources().getString(R.string.comemnts));
        viewPagerListAdapter.addTab(new RelatedFragment(),getResources().getString(R.string.related));
        pager.setAdapter(viewPagerListAdapter);
        tabs.setupWithViewPager(pager);
    }
}