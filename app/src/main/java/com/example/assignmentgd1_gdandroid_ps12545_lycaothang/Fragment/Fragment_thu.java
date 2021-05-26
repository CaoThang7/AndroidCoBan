package com.example.assignmentgd1_gdandroid_ps12545_lycaothang.Fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.assignmentgd1_gdandroid_ps12545_lycaothang.R;
import com.example.assignmentgd1_gdandroid_ps12545_lycaothang.TabFragment.Tab_Khoanthu;
import com.example.assignmentgd1_gdandroid_ps12545_lycaothang.TabFragment.Tab_Loaithu;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import adapter.KhoanTCRCVAdapter;
import adapter.TabAdapter;
import dao.KhoanThuChiDAO;
import model.KhoanThuChi;



public class Fragment_thu extends Fragment {
    //    private TabAdapter adapter;
//    private TabLayout tabLayout;
//    private ViewPager viewPager;
    RecyclerView rcv;
    KhoanTCRCVAdapter adapter;
    ArrayList<KhoanThuChi> list;
    FloatingActionButton btInsert;
    KhoanThuChiDAO khoanThuChiDAO;
    KhoanThuChi khoanThuChi;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Button setLich;
    DatePickerDialog datePickerDialog;
    Calendar lich=Calendar.getInstance();
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_thu, container, false);





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


         list=KhoanThuChiDAO.getAll(getContext(),"Thu");
//
//        list = KhoanThuChiDAO.readAll(getContext(), "Thu");
        adapter = new KhoanTCRCVAdapter(getActivity(), list);
        rcv.setAdapter(adapter);




        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getContext()," Thanh Cong!!!",
//                        Toast.LENGTH_LONG).show();
                final Dialog dialog=new Dialog(getContext());
                dialog.setContentView(R.layout.khoantc_item3);
                dialog.setTitle("Sua Thu");

                final EditText tilTen=dialog.findViewById(R.id.tvtenkhoantc3);
                final EditText tilNgay=dialog.findViewById(R.id.tvNgay3);
                final EditText tilMoney=dialog.findViewById(R.id.tvTien3);
//                final TextInputLayout tilGhiChu=dialog.findViewById(R.id.tvGhiChu);
                final EditText tilGhiChu=dialog.findViewById(R.id.tvGhiChu3);
                final Spinner spn=dialog.findViewById(R.id.spn);
                Button btnThem=dialog.findViewById(R.id.btnThem);
                Button btnHuy=dialog.findViewById(R.id.btnHuy);
//                 final ImageView setNgay=dialog.findViewById(R.id.ggg);
//                final Button setNgay=dialog.findViewById(R.id.ggg);


                setLich=dialog.findViewById(R.id.ggg);








                setLich.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        datePickerDialog=new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {


//                Toast.makeText(TimePickerDialogActivity.this,dayOfMonth + "/" +(monthOfYear+1) + "/" +year
//                        ,Toast.LENGTH_SHORT).show();



//                             tilNgay.getText().toString();
                                tilNgay.setText(year + "/" +(monthOfYear+1) + "/" +dayOfMonth);

//                timeDiaLog.setText(dayOfMonth+monthOfYear+year);




                            }
                        },
                                lich.get(Calendar.YEAR),
                                lich.get(Calendar.MONTH),
                                lich.get(Calendar.DAY_OF_MONTH));
                        datePickerDialog.show();
                    }

                });

//
////                tilTen.setText("asdas");
////                Date date = new Date();
////                tilNgay.setText(sdf.format(date));
////                tilMoney.setText("21321");
////                tilGhiChu.setText("sads");


                final ArrayAdapter adapterLop = new ArrayAdapter(getContext(),
                        android.R.layout.simple_spinner_dropdown_item,list);
                spn.setAdapter(adapterLop);

                btnThem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try{
                        String ten=tilTen.getText().toString();
                        String ngay=tilNgay.getText().toString();
                        String tien=tilMoney.getText().toString();
                        String ghichu=tilGhiChu.getText().toString();
//                        int idLoai = (int) spn.getSelectedItem();
                        KhoanThuChi tc=(KhoanThuChi) spn.getSelectedItem();
                        int idLoai=tc.getMaLoai();
                        Log.d("asv",String.valueOf(idLoai));
                            khoanThuChi = new KhoanThuChi(ten,sdf.parse(ngay), Float.parseFloat(tien), ghichu,idLoai);
                            KhoanThuChiDAO khoanthuchiDao = new KhoanThuChiDAO();
                            if(khoanthuchiDao.create(getContext(),khoanThuChi)){
                                Toast.makeText(getContext(),
                                        "Thêm thành công!!!!!!", Toast.LENGTH_LONG).show();
                                list.clear();

                                list.addAll(khoanthuchiDao.getAll(getContext(), "Thu"));
//                                Toast.makeText(getContext(),
//                                        "Thất bại!!!!!!"+list.get(1).getTien(), Toast.LENGTH_LONG).show();
                                adapter.notifyDataSetChanged();
                                dialog.dismiss();
                            }else{
                                Toast.makeText(getContext(),
                                        "Thất bại!!!!!!", Toast.LENGTH_LONG).show();
                            }
                        }catch (Exception ex){
                            Toast.makeText(getContext(),
                                    "Loi!!!!!!", Toast.LENGTH_LONG).show();
                            ex.printStackTrace();
                        }

                    }
                });
                dialog.setCancelable(false);
                dialog.show();

                btnHuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });


            }
        });





        return view;
    }






}
