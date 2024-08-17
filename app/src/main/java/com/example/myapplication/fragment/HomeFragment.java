package com.example.myapplication.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.AnnouncementsAdapter;
import com.example.myapplication.adapter.BestProductsAdapter;
import com.example.myapplication.adapter.ProductAdapter;
import com.example.myapplication.dataProvider.DataManager;
import com.example.myapplication.models.Product;

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

    public HomeFragment() {
        // Required empty public constructor
    }

    int Num = 0;
    int currentPage = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home2, container, false);

        // Initialize the views
        pager = view.findViewById(R.id.pager);
        indicator = view.findViewById(R.id.indicator); // Updated indicator
        grid_best_products = view.findViewById(R.id.grid_best_product);
        recycler_best_sellers = view.findViewById(R.id.recycler_best_sellers);

        // Initialize data manager
        dataManager = new DataManager();

        // Set up the GridView with best products
        BestProductsAdapter bestProductsAdapter = new BestProductsAdapter(getActivity(), dataManager.getBestProducts());
        grid_best_products.setAdapter(bestProductsAdapter);

        // Set up the RecyclerView for best sellers
        ProductAdapter productAdapter = new ProductAdapter(getActivity(), dataManager.getNewProducts());
        recycler_best_sellers.setAdapter(productAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recycler_best_sellers.setLayoutManager(layoutManager);

        // Set up the ViewPager2 with the AnnouncementsAdapter
        loadView(dataManager.getAnnouncements());

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
}
