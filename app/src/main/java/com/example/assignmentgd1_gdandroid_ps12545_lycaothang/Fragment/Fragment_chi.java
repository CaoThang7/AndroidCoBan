package com.example.assignmentgd1_gdandroid_ps12545_lycaothang.Fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmentgd1_gdandroid_ps12545_lycaothang.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import adapter.KhoanTCRCVAdapter;
import dao.KhoanThuChiDAO;
import model.KhoanThuChi;


public class Fragment_chi extends Fragment {

    RecyclerView rcv;
    KhoanTCRCVAdapter adapter;
    ArrayList<KhoanThuChi> list;
    FloatingActionButton btInsert;
    KhoanThuChiDAO khoanThuChiDAO;
    KhoanThuChi khoanThuChi;
    //    EditText NgayThu,Tien,MaLoai,MaTc,TenKhoanTC,GhiChu;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chi, container, false);
//        View view=inflater.inflate(R.layout.fragment_chi,container,false);
//        rcv=view.findViewById(R.id.rcvKhoanTC);
//        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
//        rcv.setLayoutManager(layoutManager);
//        list=new ArrayList<>();
////        Date date=new Date();
////
////        list.add(new KhoanThuChi(001,"abc",date, (float) 200.0,"abc",1));
////        list.add(new KhoanThuChi(002,"abcdef",date, (float) 300.0,"ttt",2));
//
//
////
//        list= KhoanThuChiDAO.readAll(getContext(),"Chi");
//        adapter=new KhoanTCRCVAdapter(getActivity(),list);
//        rcv.setAdapter(adapter);
//
//
//
//        return view;
//    }


        //        viewPager =view.findViewById(R.id.viewPager);
//        tabLayout=view.findViewById(R.id.tabLayout);
//        adapter=new TabAdapter(getActivity().getSupportFragmentManager());
//        adapter.addFragment(new Tab_Khoanthu(),"Khoản thu ");
//        adapter.addFragment(new Tab_Loaithu(),"Loại thu ");
//
//        viewPager.setAdapter(adapter);
//        tabLayout.setupWithViewPager(viewPager);

        rcv = view.findViewById(R.id.rcvKhoanTC);
        btInsert = view.findViewById(R.id.fbInsertLop);
//        MaLoai = view.findViewById(R.id.tvMaLoai);
//        MaTc = view.findViewById(R.id.tvMaTC);
//        NgayThu = view.findViewById(R.id.tvNgay);
//        Tien = view.findViewById(R.id.tvTien);
//        TenKhoanTC=view.findViewById(R.id.tvtenkhoantc);
//        GhiChu=view.findViewById(R.id.tvGhiChu);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        rcv.setLayoutManager(layoutManager);
        list = new ArrayList<>();
//        Date date=new Date();
//
//        list.add(new KhoanThuChi(001,"abc",date, (float) 200.0,"abc",1));
//        list.add(new KhoanThuChi(002,"abcdef",date, (float) 300.0,"ttt",2));


        list = KhoanThuChiDAO.getAll(getContext(), "Chi");
//
//        list = KhoanThuChiDAO.readAll(getContext(), "Thu");
        adapter = new KhoanTCRCVAdapter(getActivity(), list);
        rcv.setAdapter(adapter);


        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext()," Thanh Cong!!!",
//                        Toast.LENGTH_LONG).show();
                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.khoantc_item3);
                dialog.setTitle("Sua Thu");
                final EditText tilTen = dialog.findViewById(R.id.tvtenkhoantc3);
                final EditText tilNgay = dialog.findViewById(R.id.tvNgay3);
                final EditText tilMoney = dialog.findViewById(R.id.tvTien3);
//                final TextInputLayout tilGhiChu=dialog.findViewById(R.id.tvGhiChu);
                final EditText tilGhiChu = dialog.findViewById(R.id.tvGhiChu3);
                final Spinner spn = dialog.findViewById(R.id.spn);
                Button btnThem = dialog.findViewById(R.id.btnThem);
//                tilTen.setText("asdas");
//                Date date = new Date();
//                tilNgay.setText(sdf.format(date));
//                tilMoney.setText("21321");
//                tilGhiChu.setText("sads");


                ArrayAdapter adapterLop = new ArrayAdapter(getContext(),
                        android.R.layout.simple_spinner_dropdown_item, list);
                spn.setAdapter(adapterLop);

                btnThem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            String ten = tilTen.getText().toString();
                            String ngay = tilNgay.getText().toString();
                            String tien = tilMoney.getText().toString();
                            String ghichu = tilGhiChu.getText().toString();

//                        int idLoai = (int) spn.getSelectedItem();
                            KhoanThuChi tc = (KhoanThuChi) spn.getSelectedItem();
                            int idLoai = tc.getMaLoai();
                            Log.d("asv", String.valueOf(idLoai));
                            khoanThuChi = new KhoanThuChi(ten, sdf.parse(ngay), Float.parseFloat(tien), ghichu, idLoai);
                            KhoanThuChiDAO khoanthuchiDao = new KhoanThuChiDAO();
                            if (khoanthuchiDao.create(getContext(), khoanThuChi)) {
                                Toast.makeText(getContext(),
                                        "Thêm thành công!!!!!!", Toast.LENGTH_LONG).show();
                                list.clear();

                                list.addAll(khoanthuchiDao.getAll(getContext(), "Chi"));
//                                Toast.makeText(getContext(),
//                                        "Thất bại!!!!!!" + list.get(1).getTien(), Toast.LENGTH_LONG).show();
                                adapter.notifyDataSetChanged();
                                dialog.dismiss();
                            } else {
                                Toast.makeText(getContext(),
                                        "Thất bại!!!!!!", Toast.LENGTH_LONG).show();
                            }
                        } catch (Exception ex) {
                            Toast.makeText(getContext(),
                                    "Loi!!!!!!", Toast.LENGTH_LONG).show();
                            ex.printStackTrace();
                        }

                    }
                });
                dialog.setCancelable(false);
                dialog.show();

            }
        });


        return view;
    }
}
