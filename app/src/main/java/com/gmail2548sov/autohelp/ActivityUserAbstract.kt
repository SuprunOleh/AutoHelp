package com.gmail2548sov.autohelp

import android.os.Bundle
import android.util.Log
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class ActivityUserAbstract : AppCompatActivity() {

    abstract fun createFragment(): Fragment

    val mFragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        val fragment: Fragment? = mFragmentManager.findFragmentById(R.id.fragment_container)

        if (fragment == null) {
            mFragmentManager.beginTransaction().add(R.id.fragment_container, createFragment()).commit()

        }


    }

}