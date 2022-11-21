package com.example.database_recy;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter; // theo cai nay

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, int behavior) {
        super(fragmentManager, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Nhap();
            case 1:
                return new DanhSach();
            case 2:
                return new TimKiem();
            default:
                return new Nhap();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}


