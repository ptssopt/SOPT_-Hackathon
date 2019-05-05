package com.computer.inu.sopt_hackathon_pts.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.computer.inu.sopt_hackathon_pts.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        ll_login_parents.setOnClickListener {
      startActivity<MainActivity>()
        }
        ll_login_children.setOnClickListener {
            startActivity<ChildRequestActivity>()
        }
    }
}
