package adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmentgd1_gdandroid_ps12545_lycaothang.Fragment.Fragment_thu;
import com.example.assignmentgd1_gdandroid_ps12545_lycaothang.Lab8b2Activity;
import com.example.assignmentgd1_gdandroid_ps12545_lycaothang.MainActivity;
import com.example.assignmentgd1_gdandroid_ps12545_lycaothang.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.KhoanThuChiDAO;
import model.KhoanThuChi;

public class KhoanTCRCVAdapter extends RecyclerView.Adapter<KhoanTCRCVAdapter.KhoanTCHolder> {
    Activity context;
    ArrayList<KhoanThuChi> list;
    KhoanThuChiDAO dao;
    RecyclerView rcv;
    KhoanTCRCVAdapter adapter;
    KhoanThuChi khoanThuChi;
    EditText edtten,edtngay,edtmoney,edtghichu;
    Spinner spnn;

    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    public KhoanTCRCVAdapter(Activity context,ArrayList<KhoanThuChi>list){
        this.context=context;
        this.list=list;

    }



    @NonNull
    @Override
    public KhoanTCHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=context.getLayoutInflater();
        View view=inflater.inflate(R.layout.khoantc_item,parent,false);

        return (new KhoanTCHolder(view));

    }

    @Override
    public void onBindViewHolder(@NonNull final KhoanTCHolder holder, final int position) {
        holder.tvTieuDe.setText(list.get(position).getTenKhoanTc());
        holder.tvNgay.setText(sdf.format(list.get(position).getNgay()));
        holder.tvTien.setText(String.valueOf(list.get(position).getTien()));
        holder.tvGhiChu.setText(list.get(position).getGhiChu());
        holder.tvMaLoai.setText(String.valueOf(list.get(position).getMaLoai()));


//
//        holder.btInsert.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context," thành công!!!",
//                        Toast.LENGTH_LONG).show();
//            }
//        });


        holder.ivEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog(position);
            }
        });





        holder.ivDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final Integer MaTc =list.get(position).getMaTc();

                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setMessage("Bạn có chắn chắn xoá không?");
                builder.setTitle("Xoá");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        if(KhoanThuChiDAO.delete(context,MaTc)){
                            Toast.makeText(context," thành công!!!",
                                    Toast.LENGTH_LONG).show();
                            list.remove(position);
                            notifyDataSetChanged();
                        }

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(context," thất bại!!!",
                            Toast.LENGTH_LONG).show();

                    }
                });

                AlertDialog dialog=builder.create();
                dialog.show();




//                if(KhoanThuChiDAO.delete(context,MaTc)){
//                    Toast.makeText(context," thành công!!!",
//                            Toast.LENGTH_LONG).show();
//                    list.remove(position);
//                    notifyDataSetChanged();
//
//                }else {
//                    Toast.makeText(context," thất bại!!!",
//                            Toast.LENGTH_LONG).show();
//                }

            }


        });

    }

    @Override
    public int getItemCount() {
        return list.size();

    }



    public class KhoanTCHolder extends RecyclerView.ViewHolder{
        TextView tvTieuDe,tvNgay,tvTien,tvGhiChu,tvMaLoai;
        ImageView ivEdit,ivDel;
//        FloatingActionButton btInsert;
        CardView card;
//         RecyclerView card;

        public KhoanTCHolder(@NonNull View item) {
            super(item);
            tvTieuDe=item.findViewById(R.id.tvTieuDe);
            tvNgay=item.findViewById(R.id.tvNgay);
            tvTien=item.findViewById(R.id.tvTien);
            tvGhiChu=item.findViewById(R.id.tvGhiChuThich);
            tvMaLoai=item.findViewById(R.id.tvMaLoaikkk);

            ivEdit=item.findViewById(R.id.btnEdit);
            ivDel=item.findViewById(R.id.btnDel);
//            btInsert=item.findViewById(R.id.fbInsertLop);
            card=item.findViewById(R.id.khoantc_item);
        }
    }

    public void dialog(final int position){
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        // Get the layout inflater
        LayoutInflater inflater = context.getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        View v = inflater.inflate(R.layout.khoantc_item2, null);
        edtngay = v.findViewById(R.id.tvNgay);
        edtten = v.findViewById(R.id.tvtenkhoantc);

        edtmoney = v.findViewById(R.id.tvTien);
        edtghichu = v.findViewById(R.id.tvGhiChu);
        spnn=v.findViewById(R.id.spn);

        edtten.setText(list.get(position).getTenKhoanTc());
        edtngay.setText(sdf.format(list.get(position).getNgay()));
        edtmoney.setText(String.valueOf(list.get(position).getTien()));
        edtghichu.setText(list.get(position).getGhiChu());


        final ArrayAdapter adapterLop = new ArrayAdapter(context,
                android.R.layout.simple_spinner_dropdown_item,list);
        spnn.setAdapter(adapterLop);
        builder.setView(v)
                // Add action buttons
                .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                        try {
                            int matc = list.get(position).getMaTc();
                            String ten = edtten.getText().toString();
                            Date date = sdf.parse(String.valueOf(edtngay.getText()));
                            Float tien = Float.parseFloat(String.valueOf(edtmoney.getText()));
                            String ghichu = edtghichu.getText().toString();
//                            int maloai = list.get(position).getMaLoai();
                            KhoanThuChi tc=(KhoanThuChi) spnn.getSelectedItem();
                            int maloai=tc.getMaLoai();
                            spnn.setAdapter(adapterLop);
                            khoanThuChi = new KhoanThuChi(matc,ten, date, tien, ghichu,maloai);
                            KhoanThuChiDAO khoanthuchiDao = new KhoanThuChiDAO();
                            if(khoanthuchiDao.update(context,khoanThuChi)){
                                khoanThuChi = new KhoanThuChi(matc, ten, date, tien, ghichu, maloai);
                                list.set(position,khoanThuChi);
                                notifyDataSetChanged();
                                Toast.makeText(context,"thanh cong",Toast.LENGTH_SHORT).show();
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                            Toast.makeText(context,"Lỗi ngày",Toast.LENGTH_SHORT).show();
                        }

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();

    }

}
