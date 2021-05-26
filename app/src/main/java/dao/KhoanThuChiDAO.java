package dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import database.DbHelper;
import model.KhoanThuChi;


public class KhoanThuChiDAO {

//     DbHelper helper;
//    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//
//
//     public KhoanThuChiDAO(Context context){
//         helper=new DbHelper(context);
//     }


    public static ArrayList<KhoanThuChi> readAll(Context context, String trangthai) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        DbHelper helper = new DbHelper(context);
        ArrayList<KhoanThuChi> data = new ArrayList<>();


        //Tao databse
        SQLiteDatabase db = helper.getWritableDatabase();
        // Tao con tro = pointer( cursor) de lay du lieu

        String sql = "Select * from KHOAN_TC JOIN LOAI_TC on MaLoai = MaLoai_FK " +
                " where TrangThai = '" + trangthai + "'";
        Cursor cs = db.rawQuery(sql, null);

//         Cursor cs=db.rawQuery("select * from KHOAN_TC",null);

        cs.moveToFirst();
        while (!cs.isAfterLast()) {

            int MaTc = cs.getInt(0);
            String TenKhoanTc = cs.getString(1);
            String Ngay = cs.getString(2);
            Float Tien = cs.getFloat(3);
            String GhiChu = cs.getString(4);
            int MaLoai = cs.getInt(5);


            try {
                data.add(new KhoanThuChi(MaTc, TenKhoanTc, sdf.parse(Ngay), Tien, GhiChu, MaLoai));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            cs.moveToNext();

        }
        cs.close();
        return data;
    }


    //delete
    public static boolean delete(Context context,Integer MaTc){
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db=helper.getWritableDatabase();
        int row=db.delete("KHOAN_TC","MaTc=?",new String[]{String.valueOf(MaTc)});
        return row > 0;
    }


//    public int insert(KhoanThuChi t){
//
//    }


//    public static boolean create(Context context,KhoanThuChi tc){
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        DbHelper helper = new DbHelper(context);
//        SQLiteDatabase db=helper.getWritableDatabase();
//        ContentValues values=new ContentValues();
//        values.put("MaTc",tc.getMaTc());
//        values.put("TenKhoanTc",tc.getTenKhoanTc());
//        values.put("Ngay",sdf.format(tc.getNgay()));
//        values.put("Tien",tc.getTien());
//        values.put("GhiChu",tc.getGhiChu());
//        values.put("MaLoai",tc.getMaLoai());
//        long row=db.insert("KHOAN_TC",null,values);
//        return (row >0);
//
//    }



    public static ArrayList<KhoanThuChi>getAll(Context context, String trangthai){

        ArrayList<KhoanThuChi> ds=new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db=helper.getWritableDatabase();
        String str = "select * from KHOAN_TC JOIN LOAI_TC " +
                "on MaLoai = MaLoai_FK " +
                "where TrangThai = '"+ trangthai +"'";
        Cursor cs=db.rawQuery(str,null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){

            try {
                int ma = cs.getInt(0);
                String ten = cs.getString(1);
                Date ngay = sdf.parse(cs.getString(2));
                Float tien=cs.getFloat(3);
                String gc=cs.getString(4);
                int maloai=cs.getInt(5);
                KhoanThuChi ktc=new KhoanThuChi(ma,ten,ngay,tien,gc,maloai);
                ds.add(ktc);

            }catch (Exception ex){
                ex.printStackTrace();
            }
            cs.moveToNext();

        }
        cs.close();
        return ds;
    }




    public Boolean create(Context context, KhoanThuChi khoanthuchi){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db=helper.getReadableDatabase();
//        SQLiteDatabase db = helper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("TenKhoanTc",khoanthuchi.getTenKhoanTc());
        values.put("Ngay",sdf.format(khoanthuchi.getNgay()));
        values.put("Tien",khoanthuchi.getTien());
        values.put("GhiChu",khoanthuchi.getGhiChu());
        values.put("MaLoai_FK",khoanthuchi.getMaLoai());
        db.insert("KHOAN_TC",null,values);
        return true;
    }

//Update
    public Boolean update(Context context,KhoanThuChi khoanthuchi){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db=helper.getWritableDatabase();
//        SQLiteDatabase db = helper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("TenKhoanTc",khoanthuchi.getTenKhoanTc());
        values.put("Ngay",sdf.format(khoanthuchi.getNgay()));
        values.put("Tien",khoanthuchi.getTien());
        values.put("GhiChu",khoanthuchi.getGhiChu());
        db.update("KHOAN_TC",values,"MaTc=?",new String[]{String.valueOf(khoanthuchi.getMaTc())});
        return true;
    }


}
