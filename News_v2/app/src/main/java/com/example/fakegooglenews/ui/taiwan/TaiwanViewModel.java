package com.example.fakegooglenews.ui.taiwan;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TaiwanViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TaiwanViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("https://news.google.com/topics/CAAqJQgKIh9DQkFTRVFvSUwyMHZNRFptTXpJU0JYcG9MVlJYS0FBUAE?hl=zh-TW&gl=TW&ceid=TW%3Azh-Hant");
    }

    public LiveData<String> getText() {
        return mText;
    }
}