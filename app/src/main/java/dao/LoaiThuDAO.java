package dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import database.DbHelper;
import model.KhoanThuChi;
import model.ThuChi;

public class LoaiThuDAO {
    DbHelper helper;

    public LoaiThuDAO(Context context){
        helper=new DbHelper(context);
    }
    public ArrayList<ThuChi> readAll() {

        ArrayList<ThuChi> data=new ArrayList<>();

        //Tao databse
        SQLiteDatabase db=helper.getReadableDatabase();
        // Tao con tro = pointer( cursor) de lay du lieu
        Cursor cs=db.rawQuery("select * from LOAI_TC",null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){

            int MaLoai=cs.getInt(0);
            String TenLoai=cs.getString(1);
            String TrangThai=cs.getString(2);
            data.add(new ThuChi(MaLoai,TenLoai,TrangThai));
            cs.moveToNext();

        }
        cs.close();
        return data;

    }


}
