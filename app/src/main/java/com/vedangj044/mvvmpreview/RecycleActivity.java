package com.vedangj044.mvvmpreview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.vedangj044.mvvmpreview.databinding.ActivityRecycleBinding;

import java.util.ArrayList;
import java.util.List;

public class RecycleActivity extends AppCompatActivity {

    private ActivityRecycleBinding binding;
    private ContactDataLoad contactViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycle);

        contactViewModel = new ViewModelProvider(this).get(ContactDataLoad.class);

        final ContactAdapter contactAdapter = new ContactAdapter();
        binding.setContactAdapter(contactAdapter);

        contactViewModel.getContactData().observe(this, new Observer<List<ContactModel>>() {
            @Override
            public void onChanged(List<ContactModel> contactModels) {
                contactAdapter.contactModelsList = contactModels;
                contactAdapter.notifyDataSetChanged();
            }
        });
    }
}