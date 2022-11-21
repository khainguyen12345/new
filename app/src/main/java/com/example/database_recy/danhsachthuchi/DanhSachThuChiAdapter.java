package com.example.database_recy.danhsachthuchi;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.database_recy.R;

import java.util.List;

public class DanhSachThuChiAdapter extends RecyclerView.Adapter<DanhSachThuChiAdapter.DanhSachThuChiViewHolder>{
    private List<DanhSachThuChi> mDanhSachThuChiList;
    private Context mContext;

    public DanhSachThuChiAdapter(Context context){
        this.mContext = context;
    }

    public void setData(List<DanhSachThuChi> danhSachThuChiList){
        this.mDanhSachThuChiList = danhSachThuChiList;
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
        holder.delete.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
            builder.setTitle("Xác nhận");
            builder.setMessage("Bạn có chắc muốn xóa. :>");
            builder.setCancelable(false);
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(mContext, "Ok"+danhSachThuChi.getId(), Toast.LENGTH_SHORT).show();
                    dialogInterface.dismiss();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(mContext, "Cancel", Toast.LENGTH_SHORT).show();
                    dialogInterface.dismiss();
                }
            });
            builder.show();
        });

    }

    @Override
    public int getItemCount() {
        if(mDanhSachThuChiList != null){
            return mDanhSachThuChiList.size();
        }
        return 0;
    }

    public class DanhSachThuChiViewHolder extends RecyclerView.ViewHolder{
        private TextView hienDanhMuc;
        private TextView hienTien;
        private ImageButton delete;

        public DanhSachThuChiViewHolder(@NonNull View itemView) {

            super(itemView);
            hienDanhMuc = itemView.findViewById(R.id.hienDanhMuc);
            hienTien = itemView.findViewById(R.id.hienTien);
            delete = itemView.findViewById(R.id.delete);

        }
    }

}
