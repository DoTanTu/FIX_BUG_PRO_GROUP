package com.example.baick;

public class SanPham {
    private String name;
    private String mota;
    private String price;
    private int hinh;


    public SanPham(String name, String mota, String price, int hinh) {
        this.name = name;
        this.mota = mota;
        this.price = price;
        this.hinh = hinh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
