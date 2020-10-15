package com.vedangj044.mvvmpreview;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ContactModel {

    private String contactName, contactNumber, imageURL;

    public ContactModel(String contactName, String contactNumber, String imageURL) {
        this.contactName = contactName;
        this.contactNumber = contactNumber;
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @BindingAdapter("leadingImage")
    public static void loadImage(ImageView view, String imageURL){
        Glide.with(view.getContext())
                .load(imageURL).apply(new RequestOptions().circleCrop())
                .into(view);
    }
}
