package com.example.user.employeeattendancearchcomp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.employeeattendancearchcomp.R;
import com.example.user.employeeattendancearchcomp.database.Entry;

import java.util.List;

/**
 * Created by Md.Awon-Uz-Zaman on 11/23/2017.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    private List<Entry> users;

    public void setUsers(List<Entry> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.employeeId.setText(users.get(position).getEmployeeId());
        holder.employeeName.setText(users.get(position).getName());
        holder.employeeEmail.setText(users.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        if (users != null)
            return users.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView employeeId, employeeName, employeeEmail;

        public ViewHolder(View itemView) {
            super(itemView);
            employeeId = (TextView) itemView.findViewById(R.id.employee_id);
            employeeName = (TextView) itemView.findViewById(R.id.employee_name);
            employeeEmail = (TextView) itemView.findViewById(R.id.employee_email);
        }
    }
}
