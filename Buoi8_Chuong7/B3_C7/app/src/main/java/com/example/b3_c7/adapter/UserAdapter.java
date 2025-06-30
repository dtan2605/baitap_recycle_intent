package com.example.b3_c7.adapter;
import com.example.b3_c7.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.b3_c7.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView name, email;

        public UserViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.txtName);
            email = view.findViewById(R.id.txtEmail);
        }
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User u = userList.get(position);
        holder.name.setText(u.getName());
        holder.email.setText(u.getEmail());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
