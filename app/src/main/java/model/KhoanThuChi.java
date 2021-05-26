package model;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;
import java.util.Date;

public class KhoanThuChi {
   private int MaTc;
   private String TenKhoanTc;
   private Date Ngay;
   private Float Tien;
   private String GhiChu;
   private int MaLoai;


    @NonNull
    @Override
    public String toString() {
        return String.valueOf(getMaLoai());
    }

    public KhoanThuChi(int maTc, String tenKhoanTc, Date ngay, Float tien, String ghiChu, int maLoai) {
        MaTc = maTc;
        TenKhoanTc = tenKhoanTc;
        Ngay = ngay;
        Tien = tien;
        GhiChu = ghiChu;
        MaLoai = maLoai;
    }



    public KhoanThuChi(int maTc,String ten, Date parse, String tien, String ghichu) {
        TenKhoanTc = ten;
        Ngay = parse;
        Tien = Float.valueOf(tien);
        GhiChu = ghichu;
        MaTc=maTc;
    }

    public KhoanThuChi(Date ten, float ns, String tien, int note) {
        Ngay = ten;
        Tien = ns;
        GhiChu = tien;
        MaTc = note;
    }

    public KhoanThuChi(String ten, Date parse, float parseFloat, String ghichu,int loai) {
        TenKhoanTc=ten;
        Ngay=parse;
        Tien=parseFloat;
        GhiChu=ghichu;
        MaLoai=loai;


    }


    public int getMaTc() {
        return MaTc;
    }

    public void setMaTc(int maTc) {
        MaTc = maTc;
    }

    public String getTenKhoanTc() {
        return TenKhoanTc;
    }

    public void setTenKhoanTc(String tenKhoanTc) {
        TenKhoanTc = tenKhoanTc;
    }

    public Date getNgay() {
        return Ngay;
    }

    public void setNgay(Date ngay) {
        Ngay = ngay;
    }

    public Float getTien() {
        return Tien;
    }

    public void setTien(Float tien) {
        Tien = tien;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String ghiChu) {
        GhiChu = ghiChu;
    }

    public int getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(int maLoai) {
        MaLoai = maLoai;
    }
}
