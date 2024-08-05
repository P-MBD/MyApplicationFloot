package com.example.myapplication.dataProvider;

import com.example.myapplication.models.IData;
import com.example.myapplication.models.Product;
import java.util.ArrayList;
import java.util.List;
public class DataManager implements IData {

    @Override
    public List<Product> getBestProducts() {

        List<Product> productList=new ArrayList<>();

        Product product=new Product();
        product.setId(1);
        product.setCatId(100);
        product.setTitle("جی تی");
        product.setBulk("115");
        product.setVersionCode(12);
        product.setVersionName("1.3.11.62");
        product.setPackageName("com.kingkodestudio.z2h");
        product.setIcon("http://s.cafebazaar.ir/1/icons/com.kingkodestudio.z2h_512x512.png");
        product.setDownloadLink("kingkodestudio.apk");
        product.setRate(5f);
        product.setPrice("0");
        productList.add(product);
        //-------------------------------------------------------
        Product product1=new Product();
        product1.setId(2);
        product1.setCatId(101);
        product1.setTitle("تاکسی 360");
        product1.setBulk("5.4");
        product1.setVersionCode(12);
        product1.setVersionName("3.13");
        product1.setPackageName("com.kingkodestudio.z2h");
        product1.setIcon("http://s.cafebazaar.ir/1/icons/ftc.com.findtaxisystem_512x512.png");
        product1.setDownloadLink("kingkodestudio.apk");
        product1.setRate(4.5f);
        product1.setPrice("0");
        productList.add(product1);

        //-------------------------------------------------------
        Product product2=new Product();
        product2.setId(3);
        product2.setCatId(101);
        product2.setTitle("هارمونی");
        product2.setBulk("5.4");
        product2.setVersionCode(12);
        product2.setVersionName("3.13");
        product2.setPackageName("com.kingkodestudio.z2h");
        product2.setIcon("http://s.cafebazaar.ir/1/icons/com.lakehorse.harmony_512x512.png");
        product2.setDownloadLink("kingkodestudio.apk");
        product2.setRate(2.5f);
        product2.setPrice("0");
        productList.add(product2);



        return productList;
    }

    @Override
    public List<Product> getNewProducts() {
        return null;
    }

    @Override
    public List<Product> getBestFreeProducts() {
        return null;
    }

    @Override
    public List<Product> getAnnouncements() {
        return null;
    }
}
