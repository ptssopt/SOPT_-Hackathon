package com.computer.inu.sopt_hackathon_pts.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.computer.inu.sopt_hackathon_pts.R
import kotlinx.android.synthetic.main.activity_finish.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class FinishActivity : AppCompatActivity() {
var choice = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

            Handler().postDelayed(Runnable {
                    iv_mission_state_missionimage_star7.setImageResource(R.drawable.img_star_active)

            }, 200)//
        Handler().postDelayed(Runnable {
            iv_mission_state_missionimage_star7.setImageResource(R.drawable.img_star_unactive)

        }, 500)//

        Handler().postDelayed(Runnable {
            iv_mission_state_missionimage_star7.setImageResource(R.drawable.img_star_active)

        }, 800)//
        Handler().postDelayed(Runnable {
            iv_mission_state_missionimage_star7.setImageResource(R.drawable.img_star_unactive)

        }, 1000)//
        Handler().postDelayed(Runnable {
            iv_mission_state_missionimage_star7.setImageResource(R.drawable.img_star_active)

        }, 1400)//
        Handler().postDelayed(Runnable {
            iv_mission_state_missionimage_star7.setImageResource(R.drawable.img_star_unactive)

        }, 1700)//
        Handler().postDelayed(Runnable {
            iv_mission_state_missionimage_star7.setImageResource(R.drawable.img_star_active)
toast("획득!")
        }, 2100)//

    }


}
