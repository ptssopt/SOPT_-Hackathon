package com.computer.inu.sopt_hackathon_pts.Activity

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import com.computer.inu.sopt_hackathon_pts.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iv_main_next.visibility=View.GONE
        edt_main_mission_contents.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                iv_main_next.visibility=View.VISIBLE
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {


            }
        })

        iv_main_next.setOnClickListener {
startActivity<AddMissionActivity>("title" to edt_main_mission_contents.text.toString())
        }
    }
}
