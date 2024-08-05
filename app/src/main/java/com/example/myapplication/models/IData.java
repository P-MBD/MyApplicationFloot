package com.example.myapplication.models;

import java.util.List;



public interface IData {

    public List<Product> getBestProducts();

    public List<Product> getNewProducts();

    public List<Product> getBestFreeProducts();

    public List<Product> getAnnouncements();


}