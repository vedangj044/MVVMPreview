package com.vedangj044.mvvmpreview.roomCollection;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.w3c.dom.Text;

@Entity(tableName = "book_table")
public class BookModel {

    @PrimaryKey(autoGenerate = true)
    private int ID;

    private String bookName;

    private int bookRating;

    private String bookLogoURL;

    public BookModel(String bookName, int bookRating, String bookLogoURL) {
        this.bookName = bookName;
        this.bookRating = bookRating;
        this.bookLogoURL = bookLogoURL;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookRating() {
        return bookRating;
    }

    public void setBookRating(int bookRating) {
        this.bookRating = bookRating;
    }

    public String getBookLogoURL() {
        return bookLogoURL;
    }

    public void setBookLogoURL(String bookLogoURL) {
        this.bookLogoURL = bookLogoURL;
    }


    @BindingAdapter("formattedRating")
    public static void formatRating(TextView view, int rating){
        view.setText(String.valueOf(rating) + "/5");
    }


    @BindingAdapter("leadingImage")
    public static void loadImage(ImageView view, String imageURL){
        Glide.with(view.getContext())
                .load(imageURL).apply(new RequestOptions().circleCrop())
                .into(view);
    }

}
