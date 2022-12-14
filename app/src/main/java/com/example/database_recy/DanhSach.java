package com.example.database_recy;


import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.database_recy.Preference.MySharePreferences;


import java.util.ArrayList;
import java.util.List;

public class DanhSach extends Fragment {
    RecyclerView rcvDanhSach;
    ListView listView;
    com.example.database_recy.danhsachthuchi.DanhSachThuChiAdapter danhSachThuChiAdapter;
    DatabaseHelper db;
    MySharePreferences mySharePreferences;
    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.danh_sach,container,false);
        rcvDanhSach = view.findViewById(R.id.rcvDanhSach);
        danhSachThuChiAdapter = new com.example.database_recy.danhsachthuchi.DanhSachThuChiAdapter(inflater.getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(inflater.getContext(),RecyclerView.VERTICAL,false);
        rcvDanhSach.setLayoutManager(linearLayoutManager);


        danhSachThuChiAdapter.setData(Login.db.dsThuChi());
        rcvDanhSach.setAdapter(danhSachThuChiAdapter);
        return view;
    };

//    public List<DanhSachThuChi> getDanhSachThuChiList(){
//        List<DanhSachThuChi> list = new ArrayList<>();
//
////        while (cursor.moveToNext()){
////            list.add(new DanhSachThuChi(cursor.getInt(0), cursor.getString(2), cursor.getString(3)));
////        }
//        return list;
//
//    }
}

