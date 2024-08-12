package com.example.myapplication.models;

import android.os.Parcel;
import android.os.Parcelable;
public class Product implements Parcelable {

    private int id;
    private int catId;
    private String title;
    private String icon;
    private String shortDescription;
    private String fullDescription;
    private String price;
    private float rate;
    private int versionCode;
    private String versionName;
    private String packageName;
    private String bulk;
    private String downloadLink;

    public Product(){}


    protected Product(Parcel in) {
        id = in.readInt();
        catId = in.readInt();
        title = in.readString();
        icon = in.readString();
        shortDescription = in.readString();
        fullDescription = in.readString();
        price = in.readString();
        rate = in.readFloat();
        versionCode = in.readInt();
        versionName = in.readString();
        packageName = in.readString();
        bulk = in.readString();
        downloadLink = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(catId);
        dest.writeString(title);
        dest.writeString(icon);
        dest.writeString(shortDescription);
        dest.writeString(fullDescription);
        dest.writeString(price);
        dest.writeFloat(rate);
        dest.writeInt(versionCode);
        dest.writeString(versionName);
        dest.writeString(packageName);
        dest.writeString(bulk);
        dest.writeString(downloadLink);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getBulk() {
        return bulk;
    }

    public void setBulk(String bulk) {
        this.bulk = bulk;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }
}
