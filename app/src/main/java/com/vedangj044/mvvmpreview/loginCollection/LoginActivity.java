package com.vedangj044.mvvmpreview.loginCollection;

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
import com.vedangj044.mvvmpreview.databinding.ActivityLoginBinding;
import com.vedangj044.mvvmpreview.registerCollection.RegisterActivity;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private UserViewModel userViewModel;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        binding = DataBindingUtil.setContentView(LoginActivity.this, R.layout.activity_login);
        binding.setLifecycleOwner(this);
        binding.setUserViewModel(userViewModel);

        binding.registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        userViewModel.getCurrentUser().observe(this, new Observer<UserModel>() {
            @Override
            public void onChanged(UserModel userModel) {

                if(TextUtils.isEmpty(Objects.requireNonNull(userModel).getUsername())){
                    Toast.makeText(LoginActivity.this, "Enter Username", Toast.LENGTH_SHORT).show();
                    binding.usernameEditText.requestFocus();
                }
                else if(TextUtils.isEmpty(Objects.requireNonNull(userModel).getPassword())){
                    Toast.makeText(LoginActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    binding.passwordEditText.requestFocus();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Login done", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}