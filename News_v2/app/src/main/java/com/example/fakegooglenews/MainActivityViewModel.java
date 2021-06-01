package com.example.fakegooglenews;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public MainActivityViewModel() {
        mText = new MutableLiveData<>();
    }
    public void setmText(String s){
        mText.setValue(s);
    }
    public MutableLiveData<String> getmText() {
        return mText;
    }
}
