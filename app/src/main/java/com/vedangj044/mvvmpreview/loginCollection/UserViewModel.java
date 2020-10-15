package com.vedangj044.mvvmpreview.loginCollection;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.vedangj044.mvvmpreview.loginCollection.UserModel;

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