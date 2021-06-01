package com.example.fakegooglenews.ui.international;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InternationalViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public InternationalViewModel() {
        mText=new MutableLiveData<>();
        mText.setValue("https://news.google.com/topics/CAAqKggKIiRDQkFTRlFvSUwyMHZNRGx1YlY4U0JYcG9MVlJYR2dKVVZ5Z0FQAQ?hl=zh-TW&gl=TW&ceid=TW%3Azh-Hant");
    }


    public LiveData<String> getText(){return mText;}
}