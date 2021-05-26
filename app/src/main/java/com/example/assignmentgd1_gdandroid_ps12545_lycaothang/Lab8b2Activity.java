package com.example.assignmentgd1_gdandroid_ps12545_lycaothang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import adapter.KhoanTCRCVAdapter;
import dao.KhoanThuChiDAO;
import model.KhoanThuChi;

public class Lab8b2Activity extends AppCompatActivity {
   RecyclerView rcv;
    KhoanTCRCVAdapter adapter;
    ArrayList<KhoanThuChi>ktc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab8b2);
          rcv=findViewById(R.id.rcvKhoanTC);


        ktc=new ArrayList<>();
        Date date=new Date();
        ktc.add(new KhoanThuChi(001,"abc",date, (float) 200.0,"abc",1));
        ktc.add(new KhoanThuChi(002,"abcdef",date, (float) 300.0,"ttt",2));


        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        rcv.setLayoutManager(layoutManager);
        KhoanTCRCVAdapter adapter=new KhoanTCRCVAdapter(this, ktc);
        rcv.setAdapter(adapter);




    }




}
