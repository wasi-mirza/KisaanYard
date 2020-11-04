package com.android.kisaanyard.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.android.kisaanyard.Model.HomeModel;
import com.android.kisaanyard.R;

import java.util.ArrayList;


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.AddressViewHolder> {

    private Context context;
    private ArrayList<HomeModel> list = new ArrayList<>();
    HomeModel homeModel;

    public HomeAdapter(Context context) {
        this.context = context;
    }

    public void setList(ArrayList<HomeModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public AddressViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view ;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.item_home, viewGroup, false);
        return new AddressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressViewHolder holder, int position) {
        HomeModel homeModel = list.get(position);
        int image = homeModel.getProfileimg();
        final String title = homeModel.getTitle();

        holder.childtitle.setText(title);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class AddressViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_imagenew;
        TextView childtitle;

        public AddressViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_imagenew = itemView.findViewById(R.id.iv_maize);
            childtitle = itemView.findViewById(R.id.tv_childtitle);
         //   iv_imagenew= itemView.findViewById(R.id.iv_chana);


        }


    }


}
