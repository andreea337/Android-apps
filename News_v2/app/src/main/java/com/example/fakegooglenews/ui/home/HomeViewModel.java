package com.example.fakegooglenews.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("https://news.google.com/topstories?hl=zh-TW&gl=TW&ceid=TW:zh-Hant");
    }

    public LiveData<String> getText() {
        return mText;
    }
}