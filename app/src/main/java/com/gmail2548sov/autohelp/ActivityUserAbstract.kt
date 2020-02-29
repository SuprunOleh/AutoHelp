package com.gmail2548sov.autohelp

import android.content.res.Configuration
import android.content.res.Configuration.ORIENTATION_UNDEFINED
import android.os.Bundle
import android.util.Log
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class ActivityUserAbstract : AppCompatActivity() {


    abstract fun createFragment(): Fragment
    abstract fun getLayoutResId (): Int

    val mFragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        val fragment: Fragment? = mFragmentManager.findFragmentById(R.id.fragment_container)

        if (fragment == null) {
            mFragmentManager.beginTransaction().add(R.id.fragment_container, createFragment()).commit()

        }


    }


    open fun getScreenOrientation(): Int {
        return if (resources.configuration.orientation === Configuration.ORIENTATION_PORTRAIT) Configuration.ORIENTATION_PORTRAIT
        else if (resources.configuration.orientation === Configuration.ORIENTATION_LANDSCAPE) Configuration.ORIENTATION_LANDSCAPE else ORIENTATION_UNDEFINED
    }

}