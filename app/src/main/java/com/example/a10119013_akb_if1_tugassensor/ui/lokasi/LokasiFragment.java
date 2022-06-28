package com.example.a10119013_akb_if1_tugassensor.ui.lokasi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.a10119013_akb_if1_tugassensor.databinding.FragmentLokasiBinding;

public class LokasiFragment extends Fragment {

    private FragmentLokasiBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LokasiViewModel lokasiViewModel =
                new ViewModelProvider(this).get(LokasiViewModel.class);

        binding = FragmentLokasiBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textSlideshow;
        lokasiViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}