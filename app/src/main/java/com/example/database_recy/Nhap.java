package com.example.database_recy;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.database_recy.Preference.DataLocalManager;
import com.example.database_recy.Preference.MySharePreferences;

import java.util.Calendar;
import java.util.Date;

public class Nhap extends Fragment {
    TextView tv_thoigian;
    EditText et_nhapdanhmuc , et_nhapsotien;
    Switch sw_luachon;
    ImageButton img_add;
    UsersModel usersModel;
    View view;
    Button btn;
    DatabaseHelper db;
    MySharePreferences mySharePreferences;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.nhap,container,false);
        mySharePreferences = new MySharePreferences(getActivity());
        db = new DatabaseHelper(getActivity());

         tv_thoigian = (TextView) view.findViewById(R.id.datePick);
         et_nhapsotien = (EditText) view.findViewById(R.id.nhapSoTien);
         et_nhapdanhmuc =(EditText) view.findViewById(R.id.nhapDanhMuc);
         sw_luachon = (Switch) view.findViewById(R.id.switchTypeMoney);
         btn = (Button) view.findViewById(R.id.nhap);
         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
//                 usersModel = new UsersModel()
             }
         });
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        DatePickerDialog.OnDateSetListener setListener;

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = dayOfMonth + "/" + month + "/" +year;
                tv_thoigian.setText(date);
            }
        };

        tv_thoigian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        getContext(), android.R.style.Theme_Holo_Light_Dialog_MinWidth
                        ,setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));
                datePickerDialog.show();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String thu ,chi;
                String thoigian = tv_thoigian.getText().toString();
                String danhmuc =  et_nhapdanhmuc.getText().toString();
                Long sotien = Long.parseLong(et_nhapsotien.getText().toString());
                Boolean check = sw_luachon.isChecked();
                if(danhmuc.isEmpty() || sotien == 0) {
                    Toast.makeText(getActivity(), "Please enter all", Toast.LENGTH_SHORT).show();
                }
                if(check == false) {
                    thu = "thu";
                    UsersModel usersModel = new UsersModel(thoigian , danhmuc , sotien ,  thu);
                    Boolean insert = db.addUserInfor(usersModel , mySharePreferences.getString("userID"));
                    if(insert) {
                        Toast.makeText(getActivity(), "" + insert, Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getActivity(), "failed", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    chi = "chi";
                    UsersModel usersModel = new UsersModel(thoigian , danhmuc , sotien ,  chi);
                    Boolean insert = db.addUserInfor(usersModel, mySharePreferences.getString("userID"));
                    if(insert) {
                        Toast.makeText(getActivity(), "" + insert, Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getActivity(), "failed", Toast.LENGTH_SHORT).show();
                    }
                }

                }

        });

        return view;
    }
}
