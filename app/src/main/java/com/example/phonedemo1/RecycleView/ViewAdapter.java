package com.example.phonedemo1.RecycleView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phonedemo1.DataModel1;
import com.example.phonedemo1.R;

import java.util.ArrayList;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.MyViewHolder> {

    private ArrayList<DataModel1> All_Users;
    private RecycleViewListener listener;
    public ViewAdapter(ArrayList<DataModel1> all_Users,RecycleViewListener listener) {
        All_Users = all_Users;
        this.listener = listener;
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewuolderuser,parent,false);
        return  new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String name = All_Users.get(position).getName();
        String isActive = All_Users.get(position).isIs_Active() ==true ? "Active User" :" Disabled User";
        String phone = All_Users.get(position).getPhone_number();
         holder.name.setText(name);
         holder.isActive.setText(isActive);
         holder.phone.setText(phone);


    }



    @Override
    public int getItemCount() {
        return All_Users.size();
    }


    protected class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView name;
        private TextView isActive;
        private TextView phone;
        public MyViewHolder( View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_view_holder);
            isActive = itemView.findViewById(R.id.isActive_viewholder);
            phone = itemView.findViewById(R.id.phone_viewholder);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {

            listener.onClick(view , getAdapterPosition());
        }


    }


   public  interface  RecycleViewListener{
        void onClick( View v,int postion);
   }

}







