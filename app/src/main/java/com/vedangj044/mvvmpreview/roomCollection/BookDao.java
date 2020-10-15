package com.vedangj044.mvvmpreview.roomCollection;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BookDao {

    @Insert
    void insert(BookModel bookModel);

    @Update
    void update(BookModel bookModel);

    @Delete
    void delete(BookModel bookModel);

    @Query("SELECT * FROM book_table")
    LiveData<List<BookModel>> getAllBooks();

    @Query("SELECT * FROM book_table ORDER BY bookName")
    LiveData<List<BookModel>> getAllBooksByName();

    @Query("SELECT * FROM book_table ORDER BY bookRating DESC")
    LiveData<List<BookModel>> getAllBookByRating();
}
