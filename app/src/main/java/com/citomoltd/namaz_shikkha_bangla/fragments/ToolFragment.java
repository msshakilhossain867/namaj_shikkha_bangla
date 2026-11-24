package com.citomoltd.namaz_shikkha_bangla.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.citomoltd.namaz_shikkha_bangla.R;
import com.citomoltd.namaz_shikkha_bangla.Tasbi_activity;


public class ToolFragment extends Fragment {
    Button digital_tasbih;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_tool, container, false);

        digital_tasbih=view.findViewById(R.id.digital_tasbih);

        digital_tasbih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Tasbi_activity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}