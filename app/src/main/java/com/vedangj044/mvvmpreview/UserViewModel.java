package com.vedangj044.mvvmpreview;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserViewModel extends ViewModel {

    public MutableLiveData<String> username = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();

    private MutableLiveData<UserModel> currentUser;

    public MutableLiveData<UserModel> getCurrentUser() {
        if (currentUser == null) {
            currentUser = new MutableLiveData<>();
        }
        return currentUser;
    }

    public void onClick(View v) {
        UserModel userModel = new UserModel(username.getValue(), password.getValue());
        currentUser.setValue(userModel);
    }

}