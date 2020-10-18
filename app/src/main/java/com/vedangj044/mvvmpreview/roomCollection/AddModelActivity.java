package com.vedangj044.mvvmpreview.roomCollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.vedangj044.mvvmpreview.R;
import com.vedangj044.mvvmpreview.databinding.ActivityAddModelBinding;

public class AddModelActivity extends AppCompatActivity {

    private ActivityAddModelBinding binding;
    private AddViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_model);
        viewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(AddViewModel.class);

        viewModel.newBook.observe(this, new Observer<BookModel>() {
            @Override
            public void onChanged(BookModel bookModel) {


            }
        });

    }
}