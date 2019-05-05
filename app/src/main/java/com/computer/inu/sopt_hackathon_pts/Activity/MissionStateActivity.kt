package com.computer.inu.sopt_hackathon_pts.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.computer.inu.sopt_hackathon_pts.R
import kotlinx.android.synthetic.main.activity_mission_state.*
import org.jetbrains.anko.startActivity

class MissionStateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mission_state)
        iv_mission_state_missionimage_mailbox.setOnClickListener {
            startActivity<RequestListActivity2>()
        }
    }

    override fun onResume() {
        super.onResume()
        if(intent.getIntExtra("1",-1)==1){
            iv_mission_state_missionimage_star1.setImageResource(R.drawable.img_star_active)
        }
    }
}
