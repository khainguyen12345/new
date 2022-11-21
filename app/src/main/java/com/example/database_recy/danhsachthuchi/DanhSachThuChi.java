package com.example.database_recy.danhsachthuchi;

public class DanhSachThuChi {
    private int id;
    private String danhmuc;
    private int tien;
    private String ngay;

    public DanhSachThuChi(int id, String danhmuc, int tien, String ngay) {
        this.id = id;
        this.danhmuc = danhmuc;
        this.tien = tien;
        this.ngay = ngay;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDanhmuc() {
        return danhmuc;
    }

    public void setDanhmuc(String danhmuc) {
        this.danhmuc = danhmuc;
    }

    public int getTien() {
        return tien;
    }

    public void setTien(int tien) {
        this.tien = tien;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }
}
