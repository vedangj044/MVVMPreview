package com.vedangj044.mvvmpreview.roomCollection;

import android.app.Application;
import android.media.Rating;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class AddViewModel extends AndroidViewModel{

    private BookRepository repository;

    public AddViewModel(@NonNull Application application) {
        super(application);
        repository = new BookRepository(application);
    }

    public MutableLiveData<String> bookName = new MutableLiveData<>();
    public MutableLiveData<String> bookURL = new MutableLiveData<>();
    public MutableLiveData<Float> bookRating = new MutableLiveData<>();

    public MutableLiveData<BookModel> newBook = new MutableLiveData<>();

    public MutableLiveData<BookModel> getNewBook(){
        if(newBook == null){
            newBook = new MutableLiveData<>();
        }
        return newBook;
    }

    public void onClick(){
        BookModel bk = new BookModel(bookName.getValue(), bookRating.getValue() != null ? bookRating.getValue() : 0, bookURL.getValue());
        newBook.setValue(bk);
    }

    public void insert(BookModel bookModel){
        try {
            repository.insert(bookModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
