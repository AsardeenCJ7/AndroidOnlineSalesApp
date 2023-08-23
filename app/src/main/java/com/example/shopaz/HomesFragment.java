package com.example.shopaz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


public class HomesFragment extends Fragment {

    private RelativeLayout logoutRelativeLayout, laptops_redirect, upload_page;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_homes, container, false);

        logoutRelativeLayout = view.findViewById(R.id.logoutRedirect);
        logoutRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getContext();
                Intent intent = new Intent(context, LogIn.class);
                startActivity(intent);
            }
        });


        laptops_redirect = view.findViewById(R.id.laptops_redirect);
        laptops_redirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getContext();
                Intent intent = new Intent(context, Products.class);
                startActivity(intent);
            }
        });

        upload_page = view.findViewById(R.id.uploadProduct);
        upload_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getContext();
                Intent intent = new Intent(context, UploadProducts.class);
                startActivity(intent);
            }
        });



        return view;
    }
}
