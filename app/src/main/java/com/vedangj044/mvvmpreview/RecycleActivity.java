package com.vedangj044.mvvmpreview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.vedangj044.mvvmpreview.databinding.ActivityRecycleBinding;

import java.util.ArrayList;
import java.util.List;

public class RecycleActivity extends AppCompatActivity {

    private ActivityRecycleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycle);

        List<ContactModel> contactModelList = new ArrayList<>();
        contactModelList.add(new ContactModel("Vedang Joshi", "+91-7898454072", "https://a10.gaanacdn.com/images/albums/18/2026518/crop_480x480_2026518.jpg"));
        contactModelList.add(new ContactModel("Hello World", "+91-7898454072", "https://a10.gaanacdn.com/images/albums/18/2026518/crop_480x480_2026518.jpg"));
        contactModelList.add(new ContactModel("Data binding", "+91-7898454072", "https://a10.gaanacdn.com/images/albums/18/2026518/crop_480x480_2026518.jpg"));

        ContactAdapter contactAdapter = new ContactAdapter(contactModelList);
        binding.setContactAdapter(contactAdapter);

    }
}