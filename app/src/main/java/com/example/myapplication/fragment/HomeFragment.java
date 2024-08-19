package com.example.myapplication.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.myapplication.R;
import com.example.myapplication.adapter.AnnouncementsAdapter;
import com.example.myapplication.adapter.BestProductsAdapter;
import com.example.myapplication.adapter.ProductAdapter;
import com.example.myapplication.dataProvider.DataManager;
import com.example.myapplication.models.IResponse;
import com.example.myapplication.models.Product;
import com.example.myapplication.utils.DataParser;
import com.example.myapplication.webserviceCaller.Constants;
import com.example.myapplication.webserviceCaller.VolleyServiceCaller;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator3; // Use CircleIndicator3 for ViewPager2

public class HomeFragment extends Fragment {

    // Declare the views
    GridView grid_best_products;
    DataManager dataManager;
    RecyclerView recycler_best_sellers;
    ViewPager2 pager;
    CircleIndicator3 indicator; // Updated to CircleIndicator3 for ViewPager2 compatibility
   ProgressBar progressBar_best;
    ProgressBar progressBar_new;

    public HomeFragment() {
        // Required empty public constructor
    }

    int Num = 0;
    int currentPage = 0;
    VolleyServiceCaller volleyServiceCaller;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home2, container, false);

        // Initialize the views
        pager = view.findViewById(R.id.pager);
        indicator = view.findViewById(R.id.indicator); // Updated indicator
        grid_best_products = view.findViewById(R.id.grid_best_products);
        recycler_best_sellers = view.findViewById(R.id.recycler_best_sellers);
        progressBar_best = view.findViewById(R.id.progressBar_best);
        progressBar_new = view.findViewById(R.id.progressBar_new);
        volleyServiceCaller = new VolleyServiceCaller(getActivity());
        // Initialize data manager
        dataManager = new DataManager();

            // Set up the ViewPager2 with the AnnouncementsAdapter
        loadView(dataManager.getAnnouncements());
        getBestProducts();
        newApps();
        return view;
    }

    /**
     *
     * @param products is ok
     */
    private void loadView(List<Product> products) {
        AnnouncementsAdapter announcementsAdapter = new AnnouncementsAdapter(getActivity(), products);
        pager.setAdapter(announcementsAdapter);

        // Attach the indicator to the ViewPager2
        indicator.setViewPager(pager); // Updated to use CircleIndicator3
        Num = dataManager.getAnnouncements().size();

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (currentPage == Num) {
                    currentPage = 0;
                }
                pager.setCurrentItem(currentPage++, true);
            }
        };

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 0, 3000);

        pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // این متد هر بار که صفحه به آرامی تغییر می‌کند صدا زده می‌شود
            }

            @Override
            public void onPageSelected(int position) {
                // این متد هر بار که صفحه انتخاب شده تغییر می‌کند صدا زده می‌شود
                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // این متد هر بار که حالت جابه‌جایی صفحه تغییر می‌کند صدا زده می‌شود
            }
        });
    }
    private void getBestProducts(){
        // Set up the GridView with best products
        progressBar_best.setVisibility(View.VISIBLE);
        volleyServiceCaller.getBestProducts(new IResponse() {
            @Override
            public void onResponse(String message) throws Exception {
                Log.e("","");
                progressBar_best.setVisibility(View.GONE);
                try {

                    BestProductsAdapter adapter=new BestProductsAdapter(getActivity(),
                            DataParser.getAllProducts(message));
                    grid_best_products.setAdapter(adapter);



                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFail(String errorMessage) {
                Log.e("","");
                progressBar_best.setVisibility(View.GONE);

            }
        });


    }
    private void newApps(){

        progressBar_new.setVisibility(View.VISIBLE);
        volleyServiceCaller.getNewProducts(new IResponse() {
            @Override
            public void onResponse(String message) {
                Log.e("","");
                progressBar_new.setVisibility(View.GONE);
                try {
                    List<Product> productList=DataParser.getAllProducts(message);
                    ProductAdapter productAdapter=new ProductAdapter
                            (getActivity(),productList);

                    recycler_best_sellers.setAdapter(productAdapter);
                    LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity()
                            ,LinearLayoutManager.HORIZONTAL,false);
                    recycler_best_sellers.setLayoutManager(layoutManager);


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFail(String errorMessage) {
                Log.e("","");
                progressBar_new.setVisibility(View.GONE);
            }
        });


    }
    }



