package com.example.project_app_thu_cung;

public class GioHang {
    String hinhanh, tensp, soluong, phanloai, tongtien;
    String id;
    public GioHang(){

    }

    public GioHang(String hinhanh, String tensp, String soluong, String phanloai, String tongtien, String id) {
        this.hinhanh = hinhanh;
        this.tensp = tensp;
        this.soluong = soluong;
        this.phanloai = phanloai;
        this.tongtien = tongtien;
        this.id = id;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getPhanloai() {
        return phanloai;
    }

    public void setPhanloai(String phanloai) {
        this.phanloai = phanloai;
    }

    public String getTongtien() {
        return tongtien;
    }

    public void setTongtien(String tongtien) {
        this.tongtien = tongtien;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
