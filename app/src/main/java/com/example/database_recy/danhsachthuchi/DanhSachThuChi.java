package com.example.database_recy.danhsachthuchi;

public class DanhSachThuChi {
    private int id;
    private String danhmuc;
    private String tien;

    public DanhSachThuChi(int id, String danhmuc, String tien) {
        this.id = id;
        this.danhmuc = danhmuc;
        this.tien = tien;
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

    public String getTien() {
        return tien;
    }

    public void setTien(String tien) {
        this.tien = tien;
    }
}
