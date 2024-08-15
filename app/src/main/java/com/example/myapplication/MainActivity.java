package com.example.myapplication;



import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.example.myapplication.activity.ContactActivity;
import com.example.myapplication.adapter.BestProductsAdapter;
import com.example.myapplication.adapter.ProductAdapter;
import com.example.myapplication.dataProvider.DataManager;
import com.example.myapplication.database.FlootDatabaseHelper;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.fragment.CategoriesFragment;
import com.example.myapplication.fragment.HomeFragment;
import com.example.myapplication.fragment.UpdatesAppFragment;
import com.example.myapplication.uiDesign.DialogManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    // ImageView imageSlider;


    Toolbar toolbar;
    NavigationView navigation_slider;
    DrawerLayout drawer;
    BottomNavigationView bottom_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FlootDatabaseHelper flootDatabaseHelper = new FlootDatabaseHelper(getApplicationContext());
        Log.e("LifeCycle Main", "OnCreate");
        //imageSlider = (ImageView) findViewById(R.id.img_slider);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigation_slider = (NavigationView) findViewById(R.id.navigation_slider);
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        bottom_menu = (BottomNavigationView) findViewById(R.id.bottom_menu);


        navigation_slider.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if (id == R.id.item_telegram) {
                    Intent intent_m = new Intent(Intent.ACTION_VIEW, Uri.parse("http://telegram.me/p30droid"));
                    startActivity(intent_m);
                } else {
                    DialogManager.loginUI(MainActivity.this);
                }

                return false;
            }
        });
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this, drawer, toolbar, R.string.open, R.string.close);
        toggle.syncState();


        bottom_menu.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.item_home) {
                fragment = new HomeFragment();
            } else if (itemId == R.id.item_updates) {
                fragment = new UpdatesAppFragment();
            } else if (itemId == R.id.item_categories) {
                fragment = new CategoriesFragment();
            }

            if (fragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            }

            return true;
        });

    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.e("LifeCycle Main", "onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("LifeCycle Main", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("LifeCycle Main", "Restart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("LifeCycle Main", "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("LifeCycle Main", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("LifeCycle Main", "onDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu); }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.item_about) {
            Intent intent_m = new Intent(Intent.ACTION_VIEW, Uri.parse("http://telegram.me/p30droid"));
            startActivity(intent_m);
        } else if (id==R.id.item_exit) {
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
            alert.setTitle(getResources().getString(R.string.exit_title));
            alert.setMessage(getResources().getString(R.string.exit_message));
            alert.setIcon(android.R.drawable.ic_menu_delete);
            alert.setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    finish();

                }
            });

            alert.setNeutralButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            alert.show();

        }
//        else if(R.id.item_contact){
//            Intent intent_ahmadi = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:0912236458"));
//            startActivity(intent_ahmadi);
//        }else if(R.id.item_sms){
//            Intent intent2 = new Intent(Intent.ACTION_VIEW , Uri.parse("sms:0912236458"));
//            startActivity(intent2);
//        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {


        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(Gravity.LEFT);
        } else {
            super.onBackPressed();
        }

    }
}