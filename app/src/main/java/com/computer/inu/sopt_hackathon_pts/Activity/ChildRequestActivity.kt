package com.computer.inu.sopt_hackathon_pts.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.computer.inu.sopt_hackathon_pts.R
import kotlinx.android.synthetic.main.activity_child_request.*
import org.jetbrains.anko.startActivity

class ChildRequestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_child_request)
        iv_mission_state_missionimage_star3.setOnClickListener {
            startActivity<CameraActivity>()
        }
    }
}
