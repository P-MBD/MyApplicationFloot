package com.example.myapplication.models;

import java.util.List;

public interface IRequests {
    public void getBestProducts(IResponse response);
    public void getNewProducts(IResponse response);
    public void getAnnouncements(IResponse response);
    public void getCategories(IResponse response);
    public void register(User user,IResponse iResponse) throws Exception;

}
