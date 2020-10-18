package com.vedangj044.mvvmpreview.roomCollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.vedangj044.mvvmpreview.R;
import com.vedangj044.mvvmpreview.databinding.ActivityBookBinding;

import java.util.List;

public class BookActivity extends AppCompatActivity {

    private BookViewModel bookViewModel;
    private ActivityBookBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_book);
        bookViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(BookViewModel.class);


        final BookAdapter adapter = new BookAdapter();
        binding.setBookAdapter(adapter);

        bookViewModel.getAllBooks().observe(this, new Observer<List<BookModel>>() {
            @Override
            public void onChanged(List<BookModel> bookModels) {
                adapter.setBooks(bookModels);
            }
        });

        binding.floatingActionButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookActivity.this, AddModelActivity.class);
                startActivity(intent);
            }
        });
    }
}