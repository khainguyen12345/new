package com.example.database_recy;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.database_recy.danhsachthuchi.DanhSachThuChi;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TimKiem extends Fragment {
    private RecyclerView rcvDanhSachSearch;
    private com.example.database_recy.danhsachthuchi.DanhSachThuChiAdapter danhSachThuChiAdapter;
    private List<DanhSachThuChi> list;
    private SearchView searchView;


    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tim_kiem,container,false);

        rcvDanhSachSearch = view.findViewById(R.id.rcvDanhSach_search);
        danhSachThuChiAdapter = new com.example.database_recy.danhsachthuchi.DanhSachThuChiAdapter(inflater.getContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(inflater.getContext(),RecyclerView.VERTICAL,false);
        rcvDanhSachSearch.setLayoutManager(linearLayoutManager);

        danhSachThuChiAdapter.setData(getDanhSachThuChiList());
        rcvDanhSachSearch.setAdapter(danhSachThuChiAdapter);

        // tim kiem
        searchView = view.findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);

                return true;
            }
        });
        return view;
    }

    private void filterList(String newText) {
        List<DanhSachThuChi> filteredList = new ArrayList<>();
        for(DanhSachThuChi item : list){
            if(item.getDanhmuc().toLowerCase().contains(newText.toLowerCase())){
                filteredList.add(item);
            }
        }
        if(filteredList.isEmpty()){
            filteredList = list;
        }else{
            danhSachThuChiAdapter.setFilteredList(filteredList);
        }
    }


    public List<DanhSachThuChi> getDanhSachThuChiList(){
        list = new ArrayList<>();
        list.add(new DanhSachThuChi(1,"an uong",100000,"11/11/2222"));
        list.add(new DanhSachThuChi(2,"y te",300000,"11/11/2222"));
        list.add(new DanhSachThuChi(3,"hole",300000,"11/11/2222"));
        return list;

    }

//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        searchView = (SearchView) menu.findItem(R.id.action_timkiem).getActionView();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                danhSachThuChiAdapter.getFilter().filter(query);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                danhSachThuChiAdapter.getFilter().filter(newText);
//                return false;
//            }
//        });
//        super.onCreateOptionsMenu(menu, inflater);
//        return true;
    }

    //    @Override
//    public boolean onContextItemSelected(@NonNull MenuItem item) {
//        searchView.findViewById(R.id.searchView);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                danhSachThuChiAdapter.getFilter().filter(query);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                danhSachThuChiAdapter.getFilter().filter(newText);
//                return false;
//            }
//        });
//
//        return super.onContextItemSelected(item);
//    }

