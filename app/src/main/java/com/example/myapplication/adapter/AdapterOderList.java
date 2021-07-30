package com.example.myapplication.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.OderDetail;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AdapterOderList extends RecyclerView.Adapter<AdapterOderList.AdapterOderListHolder> {


    private Context mContext;

    List<OderDetail> listOder ;


    public AdapterOderList(Context mContext , List<OderDetail> listOder){
        this.mContext = mContext;
        this.listOder = listOder;
    }





    @NonNull
    @Override
    public AdapterOderList.AdapterOderListHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.list_order_row , parent,false);
        return new AdapterOderListHolder(view);



    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AdapterOderList.AdapterOderListHolder holder, int position) {

        try{


            String orderId = listOder.get(position).getOder_id();
            String name = listOder.get(position).getName();


            holder.textViewOderId.setText(orderId);
            holder.textViewName.setText(name);



        }catch (NullPointerException e){




        }



    }

    @Override
    public int getItemCount() {
        return listOder.size();
    }


    public class AdapterOderListHolder extends RecyclerView.ViewHolder {

        TextView textViewOderId,textViewName,textViewPhone,textViewTotalPrice,textViewStatus,textViewDateTime;
        ImageView imageViewSlip;





        public AdapterOderListHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            textViewOderId = itemView.findViewById(R.id.textViewOderId);
            textViewName = itemView.findViewById(R.id.textViewName);



        }
    }
}
