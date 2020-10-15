package com.vedangj044.mvvmpreview.roomCollection;

import android.app.Application;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BookRepository {

    private BookDao bookDao;
    private LiveData<List<BookModel>> allBooks;

    private ExecutorService executor = ExecutorHelper.getInstanceExecutor();

    public BookRepository(Application application){
        BookDatabase bookDatabase = BookDatabase.getInstance(application);
        bookDao = bookDatabase.bookDao();
        allBooks = bookDao.getAllBooks();
    }

    public void insert(final BookModel bookModel) throws ExecutionException, InterruptedException {

        Future<Void> task = executor.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                bookDao.insert(bookModel);
                return null;
            }
        });

        task.get();
    }

    public void update(final BookModel bookModel) throws ExecutionException, InterruptedException {

        Future<Void> task = executor.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                bookDao.update(bookModel);
                return null;
            }
        });

        task.get();
    }

    public void delete(final BookModel bookModel) throws ExecutionException, InterruptedException {

        Future<Void> task = executor.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                bookDao.delete(bookModel);
                return null;
            }
        });

        task.get();
    }

    public LiveData<List<BookModel>> getAllBooks(){
        return allBooks;
    }

    public LiveData<List<BookModel>> getAllBooksByName(){
        allBooks = bookDao.getAllBooksByName();
        return allBooks;
    }

    public LiveData<List<BookModel>> getAllBooksByRating(){
        allBooks = bookDao.getAllBookByRating();
        return allBooks;
    }


    public static class ExecutorHelper{

        private static ExecutorService instanceExecutor;

        public static synchronized ExecutorService getInstanceExecutor(){
            if(instanceExecutor == null){
                instanceExecutor = Executors.newSingleThreadExecutor();
            }
            return instanceExecutor;
        }
    }

}
