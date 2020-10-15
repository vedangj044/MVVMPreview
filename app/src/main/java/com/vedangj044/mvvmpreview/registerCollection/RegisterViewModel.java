package com.vedangj044.mvvmpreview.registerCollection;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vedangj044.mvvmpreview.registerCollection.RegisterModel;

public class RegisterViewModel extends ViewModel {

    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> username = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<String> repassword = new MutableLiveData<>();


    private MutableLiveData<RegisterModel> newUser;

    public MutableLiveData<RegisterModel> getNewUser(){
        if(newUser == null){
            newUser = new MutableLiveData<>();
        }
        return newUser;
    }


    public void onClick(View v){
        RegisterModel registerModel = new RegisterModel(name.getValue(), username.getValue(), password.getValue(), repassword.getValue());
        newUser.setValue(registerModel);
    }
}
