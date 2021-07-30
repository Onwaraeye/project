package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.fragment.CompletedFragment;
import com.example.myapplication.fragment.NewOrderFragment;
import com.example.myapplication.fragment.StatusFragment;

public class PageAdapter extends FragmentStateAdapter {

    public PageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position)
        {
            case 1 :
                return new StatusFragment();
            case 2 :
                return new CompletedFragment();
        }

        return new NewOrderFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
