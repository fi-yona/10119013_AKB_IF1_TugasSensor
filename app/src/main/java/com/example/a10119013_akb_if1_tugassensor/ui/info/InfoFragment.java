package com.example.a10119013_akb_if1_tugassensor.ui.info;

import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a10119013_akb_if1_tugassensor.R;
import com.example.a10119013_akb_if1_tugassensor.databinding.FragmentInfoBinding;
import com.google.android.material.tabs.TabLayout;

public class InfoFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @NonNull
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        tabLayout = view.findViewById(R.id.tab_layout_informasi);
        viewPager = view.findViewById(R.id.viewpager);

        tabLayout.setupWithViewPager(viewPager);

        InfoViewPagerAdapter infoViewPagerAdapter = new InfoViewPagerAdapter(getActivity().getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        infoViewPagerAdapter.addFragment(new TentangViewPagerFragment(), "Tentang");
        infoViewPagerAdapter.addFragment(new VersiViewPagerFragment(), "Versi");
        infoViewPagerAdapter.addFragment(new MadeByViewPagerFragment(), "Made by");
        viewPager.setAdapter(infoViewPagerAdapter);

        return view;

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}