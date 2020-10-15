package com.vedangj044.mvvmpreview.roomCollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

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

//        bookViewModel.insert(new BookModel("Da Vinci Code", 3, "https://static.rogerebert.com/uploads/review/primary_image/reviews/the-da-vinci-code-2006/EB20060518REVIEWS60419009AR.jpg"));
    }
}