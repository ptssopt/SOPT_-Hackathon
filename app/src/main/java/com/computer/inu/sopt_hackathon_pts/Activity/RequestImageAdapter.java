package com.computer.inu.sopt_hackathon_pts.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.computer.inu.sopt_hackathon_pts.R;

import java.util.ArrayList;

public class RequestImageAdapter extends RecyclerView.Adapter<RequestImageAdapter.ViewHolder> {

    private int[] itemsData=new int[10];
    private Context ctx;

    public RequestImageAdapter(int[] imgUrl, Context ctx){
        this.ctx = ctx;
        for(int i=0;i<10;i++){
            this.itemsData[i] = imgUrl[i];//이미지 받아오기
        }

    }

    @Override
    public RequestImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_item_request_list, null);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.img_rv_item_request.setImageResource(this.itemsData[i]);
        // Glide.with(ctx).load(itemsData[i]).into(viewHolder.img_rv_item_request);
        //  Glide.with(ctx).load(itemsData.get(i)).into(viewHolder.img_rv_item_request);
        // this.itemsData[i] 띄우기 -> viewHolder.img_rv_item_request에다가
        // www.naver.com/image_logo.png
        // Glide Library

        viewHolder.img_rv_item_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx, RequestDetailActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //클릭했을 때 뷰 넘기기
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView img_rv_item_request;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_rv_item_request = (ImageView)itemView.findViewById(R.id.img_rv_item_request);
        }
    }
}