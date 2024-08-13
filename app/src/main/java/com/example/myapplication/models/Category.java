package com.example.myapplication.models;

public class Category {
    private int id;                 // شناسه دسته‌بندی
    private String name;            // نام دسته‌بندی
    private String description;     // توضیحات دسته‌بندی (اختیاری)
    private String iconUrl;         // آدرس تصویر نماد دسته‌بندی

    // سازنده پیش‌فرض (بدون آرگومان)
    public Category() {
    }

    // سازنده با آرگومان‌ها
    public Category(int id, String name, String description, String iconUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.iconUrl = iconUrl;
    }

    // Getter و Setter برای شناسه
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter و Setter برای نام
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter و Setter برای توضیحات
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter و Setter برای آدرس تصویر نماد
    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                '}';
    }
}
