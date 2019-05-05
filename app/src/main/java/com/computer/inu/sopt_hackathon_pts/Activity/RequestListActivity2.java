package com.computer.inu.sopt_hackathon_pts.Activity;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.computer.inu.sopt_hackathon_pts.R;
import github.hellocsl.layoutmanager.gallery.GalleryLayoutManager;

import java.util.ArrayList;

public class RequestListActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_list);

        configureRecyclerView();
    }

    private void configureRecyclerView(){
        RecyclerView rv_request_list = (RecyclerView)findViewById(R.id.rv_request_list);

        GalleryLayoutManager galleryLayoutManager = new GalleryLayoutManager(GalleryLayoutManager.HORIZONTAL);
        galleryLayoutManager.attach(rv_request_list);

        int[] images=new int[10];
        for(int i=0;i<10;i++){
            images[i]=R.drawable.lego_princess;
        }

        RequestImageAdapter requestImageAdapter = new RequestImageAdapter(images, getApplicationContext());
        rv_request_list.setAdapter(requestImageAdapter);

        galleryLayoutManager.setItemTransformer(new ScaleTransformer());
    }
}