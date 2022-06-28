package com.example.a10119013_akb_if1_tugassensor.ui.restoran;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.a10119013_akb_if1_tugassensor.databinding.FragmentRestoranBinding;

public class RestoranFragment extends Fragment {

    private FragmentRestoranBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RestoranViewModel restoranViewModel =
                new ViewModelProvider(this).get(RestoranViewModel.class);

        binding = FragmentRestoranBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGallery;
        restoranViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}