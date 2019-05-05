package com.computer.inu.sopt_hackathon_pts.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.computer.inu.sopt_hackathon_pts.R;

public class RequestDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_detail);
        Button btn=(Button)findViewById(R.id.btn_accept);
        btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), MissionStateActivity.class);
                        intent.putExtra("1",1);
                        //클릭했을 때 뷰 넘기기
                        startActivity(intent);
                    }
                });
    }
}
