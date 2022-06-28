package com.example.a10119013_akb_if1_tugassensor.ui.restoran;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RestoranViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RestoranViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}