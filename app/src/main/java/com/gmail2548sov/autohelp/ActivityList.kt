package com.gmail2548sov.autohelp

import android.content.res.Configuration
import android.provider.Settings.System.getConfiguration
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import androidx.fragment.app.Fragment
import com.gmail2548sov.autohelp.SingltonUser.listUsers


class ActivityList : ActivityUserAbstract() {


    override fun getLayoutResId() = when (getScreenOrientation()) {
        Configuration.ORIENTATION_PORTRAIT -> R.layout.activity_user
        Configuration.ORIENTATION_LANDSCAPE -> R.layout.activity_twopane
        else -> R.layout.activity_user
    }


    override fun createFragment(): Fragment {
        Log.d("888", "${listUsers[1].toString()}")
        return FragmentList()
    }


}

