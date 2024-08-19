package com.example.myapplication.utils;

import com.example.myapplication.models.Product;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DataParser {

    public static List<Product> getAllProducts(String message)throws Exception{

        List<Product> productList=new ArrayList<>();

        JSONArray jsonArray=new JSONArray(message);

        for(int i=0;i<jsonArray.length();i++){
            JSONObject jsonObject=jsonArray.getJSONObject(i);

            Product product=new Product();
            product.setId(Integer.parseInt(jsonObject.getString("id")));
            product.setCatId(Integer.parseInt(jsonObject.getString("cat_id")));
            product.setTitle(jsonObject.getString("title"));
            product.setIcon(jsonObject.getString("icon"));
            product.setPackageName(jsonObject.getString("packageName"));
            product.setVersionName(jsonObject.getString("versionName"));
            product.setVersionCode(Integer.parseInt(jsonObject.getString("versionCode")));
            product.setShortDescription(jsonObject.getString("shortDescription"));
            product.setFullDescription(jsonObject.getString("fullDescription"));
            product.setPrice(jsonObject.getString("price"));
            product.setRate(Float.parseFloat(jsonObject.getString("rate")));
            product.setDownloadLink(jsonObject.getString("downloadLink"));

            productList.add(product);
        }


        return productList;
    }

}

