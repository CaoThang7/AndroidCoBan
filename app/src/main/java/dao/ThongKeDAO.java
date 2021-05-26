package dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import database.DbHelper;

public class ThongKeDAO {
    public static double tongTienTheoTT(Context context,String trangthai){
        double tongTien=0;
        DbHelper helper=new DbHelper(context);
        SQLiteDatabase db=helper.getReadableDatabase();
        String str = "select SUM(Tien) as TongTien " +
                "from KHOAN_TC JOIN LOAI_TC  " +
                "on MaLoai = MaLoai_FK " +
                "where TrangThai = '"+ trangthai +"'";
        Cursor cs=db.rawQuery(str,null);
        cs.moveToFirst();
        if(cs.getCount()>0){
            tongTien=cs.getDouble(0);
        }
        return tongTien;

    }

}
