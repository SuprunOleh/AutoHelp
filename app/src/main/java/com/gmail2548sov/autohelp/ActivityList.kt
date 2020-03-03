package com.gmail2548sov.autohelp

import android.content.Intent
import android.content.res.Configuration
import android.provider.Settings.System.getConfiguration
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.gmail2548sov.autohelp.SingltonUser.listUsers
import javax.security.auth.callback.Callback


class ActivityList: ActivityUserAbstract(), FragmentList.Callbacks, FragmentUser.Callbacks {


    override fun getLayoutResId(): Int {
        return R.layout.activity_masterdetail
    }

    override fun createFragment(): Fragment {
        return FragmentList()
    }

    override fun onUsersSelected(dataUser: DataUser) {
        if (findViewById<FrameLayout>(R.id.detail_fragment_container) == null) {


            val intent = ActivityUserPager.newIntent(this, dataUser.mId)
            startActivity(intent)









        } else {
            var newDetailUser: Fragment = FragmentUser.newInstanse(dataUser.mId)
            val fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction()
                .replace(R.id.detail_fragment_container, newDetailUser).commit()
        }
    }

    override fun onUserUpdated(dataUser: DataUser?) {
        Log.d ("up333", "up333")
        val listFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as FragmentList
        listFragment.updateUI()
    }

}

