package com.computer.inu.sopt_hackathon_pts.DB

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceController {

    private val PW = "PW"
    private val myPW = "myPW"

    fun setPW(context: Context, authorization: String) {
        val pref = context.getSharedPreferences(PW, Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString(myPW, authorization)
        editor.commit()
    }
    fun getPW(context: Context): String {
        val pref = context.getSharedPreferences(PW, Context.MODE_PRIVATE)
        return pref.getString(myPW, "")
    }

    fun clearPW(context: Context) {
        val pref = context.getSharedPreferences(PW, Context.MODE_PRIVATE)
        val editor = pref.edit()
        editor.clear()
        editor.commit()
    }
}