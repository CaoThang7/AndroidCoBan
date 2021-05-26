package com.example.assignmentgd1_gdandroid_ps12545_lycaothang.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.assignmentgd1_gdandroid_ps12545_lycaothang.R;

import dao.ThongKeDAO;


public class Fragment_thongke extends Fragment {
    TextView tvTongThu,tvTongChi;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_thongke,container,false);
        tvTongThu=view.findViewById(R.id.tkTongThu);
        tvTongChi=view.findViewById(R.id.tkTongChi);

        double tongThu= ThongKeDAO.tongTienTheoTT(getContext(),"Thu");
        tvTongThu.setText("Tổng Thu là: " + tongThu + " " + "VND");


        double tongChi= ThongKeDAO.tongTienTheoTT(getContext(),"Chi");
        tvTongChi.setText("Tổng chi là: " + tongChi + " " +"VND");
        return view;

    }
}
