package com.vedangj044.mvvmpreview.recycleCollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.vedangj044.mvvmpreview.R;
import com.vedangj044.mvvmpreview.databinding.ActivityRecycleBinding;
import com.vedangj044.mvvmpreview.recycleCollection.ContactAdapter;
import com.vedangj044.mvvmpreview.recycleCollection.ContactDataLoad;
import com.vedangj044.mvvmpreview.recycleCollection.ContactModel;

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