package com.example.database_recy.danhsachthuchi;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.database_recy.R;
import com.example.database_recy.danhsachthuchi.DanhSachThuChi;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DanhSachThuChiAdapter extends RecyclerView.Adapter<DanhSachThuChiAdapter.DanhSachThuChiViewHolder> implements Filterable {
    private List<DanhSachThuChi> mDanhSachThuChiList;
    private List<DanhSachThuChi> mDanhSachThuChiListOld;
    private Context mContext;

    public DanhSachThuChiAdapter(Context context){
        this.mContext = context;
    }

    public void setData(List<DanhSachThuChi> danhSachThuChiList){
        this.mDanhSachThuChiList = danhSachThuChiList;
        this.mDanhSachThuChiListOld = danhSachThuChiList;
        notifyDataSetChanged();

    }
    @NonNull
    @Override
    public DanhSachThuChiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item,parent,false);
        return new DanhSachThuChiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DanhSachThuChiViewHolder holder, int position) {
        DanhSachThuChi danhSachThuChi = mDanhSachThuChiList.get(position);
        if(danhSachThuChi == null){
            return;
        }
        holder.hienDanhMuc.setText(danhSachThuChi.getDanhmuc());
        holder.hienTien.setText(""+danhSachThuChi.getTien());
        holder.hienNgay.setText(danhSachThuChi.getNgay());
        holder.delete.setOnClickListener(view -> {
            Toast.makeText(mContext, ""+danhSachThuChi.getId(), Toast.LENGTH_SHORT).show();
//            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
//            builder.setTitle("Xác nhận");
//            builder.setMessage("Bạn có chắc muốn xóa. :>");
//            builder.setCancelable(false);
//            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    Toast.makeText(mContext, "Ok"+danhSachThuChi.getId(), Toast.LENGTH_SHORT).show();
//                    dialogInterface.dismiss();
//                }
//            });
//            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    Toast.makeText(mContext, "Cancel", Toast.LENGTH_SHORT).show();
//                    dialogInterface.dismiss();
//                }
//            });
//            builder.show();
        });

    }

    @Override
    public int getItemCount() {
        if(mDanhSachThuChiList != null){
            return mDanhSachThuChiList.size();
        }
        return 0;
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    public void setFilteredList(List<DanhSachThuChi> filteredList){
        this.mDanhSachThuChiList = filteredList;
        notifyDataSetChanged();
    }

    public class DanhSachThuChiViewHolder extends RecyclerView.ViewHolder{
        private TextView hienDanhMuc;
        private TextView hienTien;
        private ImageButton delete;
        private TextView hienNgay;

        public DanhSachThuChiViewHolder(@NonNull View itemView) {

            super(itemView);
            hienDanhMuc = itemView.findViewById(R.id.hienDanhMuc);
            hienTien = itemView.findViewById(R.id.hienTien);
            delete = itemView.findViewById(R.id.delete);
            hienNgay = itemView.findViewById(R.id.ngay);
        }
    }

//    @Override
//    public Filter getFilter() {
//        return new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence charSequence) {
//                String strSearch = charSequence.toString();
//                if(strSearch.isEmpty()){
//                    mDanhSachThuChiList = mDanhSachThuChiListOld;
//                } else{
//                    List<DanhSachThuChi> list = new ArrayList<>();
//                    for (DanhSachThuChi danhSachThuChi : mDanhSachThuChiListOld) {
//                        if(danhSachThuChi.getDanhmuc().toLowerCase().contains(strSearch.toLowerCase())){
//                            list.add((danhSachThuChi));
//                        }
//                    }
//                    mDanhSachThuChiList = list;
//                }
//
//                FilterResults filterResults = new FilterResults();
//                filterResults.values = mDanhSachThuChiList;
//
//                return filterResults;
//            }

//            @Override
//            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
//                mDanhSachThuChiList = (List<DanhSachThuChi>) filterResults.values;
//                notifyDataSetChanged();
//            }
        }
