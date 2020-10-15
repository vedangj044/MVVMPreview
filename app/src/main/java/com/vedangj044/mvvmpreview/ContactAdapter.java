package com.vedangj044.mvvmpreview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vedangj044.mvvmpreview.databinding.ContactItemBinding;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    public List<ContactModel> contactModelsList = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ContactItemBinding itemBinding = ContactItemBinding.inflate(inflater, parent, false);
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ContactModel contactModel = contactModelsList.get(position);
        holder.bind(contactModel);
    }

    @Override
    public int getItemCount() {
        return contactModelsList != null ? contactModelsList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ContactItemBinding binding;

        public ViewHolder(ContactItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(ContactModel contactModel){
            binding.setContactModel(contactModel);
            binding.executePendingBindings();
        }

    }
}
