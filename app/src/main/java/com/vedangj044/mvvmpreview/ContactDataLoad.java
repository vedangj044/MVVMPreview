package com.vedangj044.mvvmpreview;

import android.os.CountDownTimer;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class ContactDataLoad extends ViewModel {

    private MutableLiveData<List<ContactModel>> contactData;

    public MutableLiveData<List<ContactModel>> getContactData(){
        if(contactData == null){
            contactData = new MutableLiveData<>();
            loadData();
        }

        return contactData;
    }


    CountDownTimer cp = new CountDownTimer(10000, 2000) {
        @Override
        public void onTick(long millisUntilFinished) {
            Log.v("lo", "tick");
            contactData.getValue().add(new ContactModel("Vedang Joshi", "+91-7898454072", "https://a10.gaanacdn.com/images/albums/18/2026518/crop_480x480_2026518.jpg"));
            contactData.setValue(contactData.getValue());
        }

        @Override
        public void onFinish() {

        }
    };

    public void loadData(){
        this.contactData.setValue(new ArrayList<ContactModel>());
        cp.start();
    }
}
