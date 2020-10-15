package com.vedangj044.mvvmpreview.roomCollection;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vedangj044.mvvmpreview.R;
import com.vedangj044.mvvmpreview.databinding.BookItemBinding;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private List<BookModel> books = new ArrayList<>();


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        BookItemBinding bookItemBinding = BookItemBinding.inflate(inflater, parent, false);

        return new ViewHolder(bookItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        BookModel bookModel = books.get(position);
        holder.bind(bookModel);

    }

    public void setBooks(List<BookModel> books){
        this.books = books;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return books != null ? books.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private BookItemBinding binding;

        public ViewHolder(BookItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(BookModel bookModel){
            binding.setBookModel(bookModel);
            binding.executePendingBindings();
        }

    }

}
