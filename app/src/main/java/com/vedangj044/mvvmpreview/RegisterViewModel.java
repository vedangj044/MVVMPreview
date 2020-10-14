package com.vedangj044.mvvmpreview;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RegisterViewModel extends ViewModel {

    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> username = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<String> repassword = new MutableLiveData<>();


    private MutableLiveData<UserModel> newUser;

    public MutableLiveData<UserModel> getNewUser(){
        if(newUser == null){
            newUser = new MutableLiveData<>();
        }
        return newUser;
    }

    public MutableLiveData<String> getRePass(){
        if(repassword == null){
            repassword = new MutableLiveData<>();
        }
        return repassword;
    }

    public void onClick(View v){
        UserModel userModel = new UserModel(name.getValue(), username.getValue(), password.getValue());
        validPassword();
        newUser.setValue(userModel);
    }

    public Boolean validPassword(){
        Log.v("aa", password.getValue() +"  "+ repassword.getValue());
        return password.getValue().equals(repassword.getValue());
    }

}
