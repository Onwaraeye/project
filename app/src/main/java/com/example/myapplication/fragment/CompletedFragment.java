package com.example.myapplication.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapter.AdapterOderList;
import com.example.myapplication.models.OderDetail;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CompletedFragment extends Fragment {

///////
    // class variable
    final String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";

    final java.util.Random rand = new java.util.Random();

    // consider using a Map<String,Boolean> to say whether the identifier is being used or not
    final Set<String> identifiers = new HashSet<String>();
//////



    private RecyclerView listViewOrder;
    private AdapterOderList adapterOderList;
    private List<OderDetail> listData  = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =   inflater.inflate(R.layout.fragment_new_order, container, false);
        listViewOrder = view.findViewById(R.id.listViewOrder);


        getListData();



        return view;

    }

    private void getListData(){


        for(int i = 0;i < 10;i++){

            OderDetail oderDetail = new OderDetail();
            oderDetail.setOder_id(i+"");
            oderDetail.setName(randomIdentifier());


            /*if(oderDetail.getOder_id().equals("5") || oderDetail.getOder_id().equals("6"))*/{
                listData.add(oderDetail);
            }




        }


        adapterOderList = new AdapterOderList(getActivity(),listData);
        listViewOrder.setLayoutManager(new LinearLayoutManager(getActivity()));
        listViewOrder.setAdapter(adapterOderList);


    }

    public String randomIdentifier() {
        StringBuilder builder = new StringBuilder();
        while(builder.toString().length() == 0) {
            int length = rand.nextInt(5)+5;
            for(int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
            if(identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }
}