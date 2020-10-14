package com.vedangj044.mvvmpreview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.vedangj044.mvvmpreview.databinding.ActivityRegisterBinding;

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

        registerViewModel.getNewUser().observe(this, new Observer<UserModel>() {
            @Override
            public void onChanged(UserModel userModel) {

//                UserModel model = Objects.requireNonNull(userModel);
//                Boolean available = TextUtils.isEmpty(model.getName()) && TextUtils.isEmpty(model.getUsername()) && TextUtils.isEmpty(model.getPassword());
//
//                if(!available){
                    Toast.makeText(RegisterActivity.this, "Fields cant be empty", Toast.LENGTH_SHORT).show();
//                }
            }
        });

        registerViewModel.getRePass().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {

                Log.v("A", "Ass");
                if(s.equals(registerViewModel.password.getValue())){
                    activityRegisterBinding.repasswordEditText.setBackgroundColor(Color.parseColor("#a5ecd7"));
                }
                else{
                    activityRegisterBinding.repasswordEditText.setBackgroundColor(Color.parseColor("#e97171"));
                }

            }
        });

    }
}