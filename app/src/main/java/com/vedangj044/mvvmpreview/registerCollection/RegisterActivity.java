package com.vedangj044.mvvmpreview.registerCollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.vedangj044.mvvmpreview.R;
import com.vedangj044.mvvmpreview.databinding.ActivityRegisterBinding;
import com.vedangj044.mvvmpreview.recycleCollection.RecycleActivity;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    public RegisterViewModel registerViewModel;
    public ActivityRegisterBinding activityRegisterBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        registerViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);

        activityRegisterBinding = DataBindingUtil.setContentView(RegisterActivity.this, R.layout.activity_register);
        activityRegisterBinding.setLifecycleOwner(this);
        activityRegisterBinding.setRegisterModel(registerViewModel);


        registerViewModel.getNewUser().observe(this, new Observer<RegisterModel>() {
            @Override
            public void onChanged(RegisterModel registerModel) {

                boolean flag = false;

                if(TextUtils.isEmpty(Objects.requireNonNull(registerModel).getName())){
                    flag = true;
                    activityRegisterBinding.nameEditText.setError("Enter Name");
                }
                else{
                    activityRegisterBinding.nameEditText.setError(null);
                }

                if(TextUtils.isEmpty(Objects.requireNonNull(registerModel).getUsername())){
                    flag = true;
                    activityRegisterBinding.emailEditText.setError("Enter Username");
                }
                else {
                    activityRegisterBinding.emailEditText.setError(null);
                }

                if(TextUtils.isEmpty(Objects.requireNonNull(registerModel).getPassword())){
                    flag = true;
                    activityRegisterBinding.passwordEditText.setError("Enter password");
                }
                else {
                    activityRegisterBinding.passwordEditText.setError(null);
                }

                if(!flag && !registerModel.getPassword().equals(registerModel.getRepassword())){
                    flag = true;
                    activityRegisterBinding.repasswordEditText.setError("Password mismatch");
                }
                else{
                    activityRegisterBinding.repasswordEditText.setError(null);
                }

                if(!flag){
                    Toast.makeText(RegisterActivity.this, "Registration Complete", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}