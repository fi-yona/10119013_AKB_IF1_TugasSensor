package com.example.a10119013_akb_if1_tugassensor.ui.lokasi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LokasiViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public LokasiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}