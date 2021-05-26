package com.example.assignmentgd1_gdandroid_ps12545_lycaothang.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmentgd1_gdandroid_ps12545_lycaothang.R;

import java.util.ArrayList;
import java.util.Date;

import adapter.KhoanTCRCVAdapter;
import dao.KhoanThuChiDAO;
import model.KhoanThuChi;

public class KhoanTCFragment extends Fragment {
    RecyclerView rcv;
    KhoanTCRCVAdapter adapter;
    ArrayList<KhoanThuChi>list;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_khoan_tc,container,false);
        rcv=view.findViewById(R.id.rcvKhoanTC);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        rcv.setLayoutManager(layoutManager);
        list=new ArrayList<>();
//        Date date=new Date();
//
//        list.add(new KhoanThuChi(001,"abc",date, (float) 200.0,"abc",1));
//        list.add(new KhoanThuChi(002,"abcdef",date, (float) 300.0,"ttt",2));


//
        list= KhoanThuChiDAO.readAll(getContext(),"ggg");
        adapter=new KhoanTCRCVAdapter(getActivity(),list);
        rcv.setAdapter(adapter);



        return view;
    }
}
