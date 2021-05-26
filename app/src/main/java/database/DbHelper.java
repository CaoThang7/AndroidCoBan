package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context){super(context,"QLChiTieu",null,1);}


    @Override
    public void onCreate(SQLiteDatabase db) {
        //Tạo bảng loại thu chi
        String sql="CREATE TABLE LOAI_TC(MaLoai integer primary key autoincrement,"+
                "TenLoai text, TrangThai text)";
        db.execSQL(sql);
        sql="INSERT INTO LOAI_TC(TenLoai,TrangThai) VALUES('Lai ngan hang','Thu')";
        db.execSQL(sql);
        sql="INSERT INTO LOAI_TC(TenLoai,TrangThai) VALUES('Luong','Thu')";
        db.execSQL(sql);
        sql="INSERT INTO LOAI_TC(TenLoai,TrangThai) VALUES('Ban hang','Thu')";
        db.execSQL(sql);
        sql="INSERT INTO LOAI_TC(TenLoai,TrangThai) VALUES('Thu no','Thu')";
        db.execSQL(sql);
        sql="INSERT INTO LOAI_TC(TenLoai,TrangThai) VALUES('Sinh hoat hang ngay','Chi')";
        db.execSQL(sql);
        sql="INSERT INTO LOAI_TC(TenLoai,TrangThai) VALUES('Dong tien hoc','Chi')";
        db.execSQL(sql);
        sql="INSERT INTO LOAI_TC(TenLoai,TrangThai) VALUES('Du lich','Chi')";
        db.execSQL(sql);

        //Tạo bảng khoản thu chi

        //Khoan thu
        sql ="CREATE TABLE KHOAN_TC(MaTc integer primary key autoincrement,"+
                "TenKhoanTc text,Ngay Date,Tien Float, GhiChu Text,"+
                "MaLoai_FK integer references LOAI_TC(MaLoai))";
        db.execSQL(sql);
        sql="INSERT INTO KHOAN_TC(TenKhoanTc,Ngay,Tien,GhiChu,MaLoai_FK) VALUES('Lãi ngân hàng tháng 1/2020','2020-1-1',500,'ggg',1)";
        db.execSQL(sql);
        sql="INSERT INTO KHOAN_TC(TenKhoanTc,Ngay,Tien,GhiChu,MaLoai_FK) VALUES('Lương tháng 2/2020','2020-2-2',600,'ttt',2)";
        db.execSQL(sql);
        sql="INSERT INTO KHOAN_TC(TenKhoanTc,Ngay,Tien,GhiChu,MaLoai_FK) VALUES('Bán hàng tháng 3/2020','2020-3-3',700,'ttt',3)";
        db.execSQL(sql);
        sql="INSERT INTO KHOAN_TC(TenKhoanTc,Ngay,Tien,GhiChu,MaLoai_FK) VALUES('Thu nợ 4/2020','2020-4-4',800,'ttt',4)";
        db.execSQL(sql);

       //Khoan chi
        sql="INSERT INTO KHOAN_TC(TenKhoanTc,Ngay,Tien,GhiChu,MaLoai_FK) VALUES('Sinh hoạt hằng ngày','2001-1-1',50,'ttt',5)";
        db.execSQL(sql);
        sql="INSERT INTO KHOAN_TC(TenKhoanTc,Ngay,Tien,GhiChu,MaLoai_FK) VALUES('Đóng tiền học','2001-1-1',8.000000,'ttt',6)";
        db.execSQL(sql);
        sql="INSERT INTO KHOAN_TC(TenKhoanTc,Ngay,Tien,GhiChu,MaLoai_FK) VALUES('Du lịch','2001-1-1',2.000000,'ttt',7)";
        db.execSQL(sql);



        sql="CREATE TABLE QUANTRI(username text primary key, password text)";
        db.execSQL(sql);
        sql="INSERT INTO QUANTRI VALUES('admin','admin')";
        db.execSQL(sql);
        sql="INSERT INTO QUANTRI VALUES('admin2','123')";
        db.execSQL(sql);




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists LOAI_TC");
        db.execSQL("Drop table if exists KHOAN_TC");
        onCreate(db);

    }
}
