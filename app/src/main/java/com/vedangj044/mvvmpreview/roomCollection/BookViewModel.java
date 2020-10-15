package com.vedangj044.mvvmpreview.roomCollection;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;


public class BookViewModel extends AndroidViewModel {

    private BookRepository repository;
    private LiveData<List<BookModel>> allBooks;

    public BookViewModel(@NonNull Application application) {
        super(application);
        repository = new BookRepository(application);
        allBooks = repository.getAllBooks();
    }

    public void insert(BookModel bookModel){
        try {
            repository.insert(bookModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(BookModel bookModel){
        try {
            repository.update(bookModel);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(BookModel bookModel){
        try {
            repository.delete(bookModel);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getAllBooksByName(){
        allBooks = repository.getAllBooksByName();
    }

    public void getAllBooksByRating(){
        allBooks = repository.getAllBooksByRating();
    }

    public LiveData<List<BookModel>> getAllBooks(){
        return allBooks;
    }
}
