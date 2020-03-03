package com.gmail2548sov.autohelp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import kotlinx.android.synthetic.main.activiti_user_page.*
import java.util.*

class ActivityUserPager : AppCompatActivity(), FragmentUser.Callbacks {

    companion object {

        val EXTRA_ID: String = "id_com.gmail2548sov.autohelp"

        fun newIntent(context: Context?, userId: UUID): Intent {
            val intent = Intent(context, ActivityUserPager::class.java)
            intent.putExtra(EXTRA_ID, userId)
            return intent
        }
    }

    override fun onUserUpdated(dataUser: DataUser?) {



//        Log.d ("up333", "up333")
//        val listFragment =
//            supportFragmentManager.findFragmentById(R.id.fragment_container) as FragmentList
//        listFragment.updateUI()
    }



    val dataUsers: List<DataUser> = SingltonUser.listUsers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activiti_user_page)


        val userId = intent.getSerializableExtra(EXTRA_ID) as UUID








        val pagerUser = pager_user
        val fragmentManager = supportFragmentManager
        pagerUser.adapter = (object : FragmentStatePagerAdapter(fragmentManager) {


            override fun getItem(position: Int): Fragment {
                val userData = dataUsers.get(position)
                return FragmentUser.newInstanse(userData.mId)


            }


            override fun getCount(): Int {
                return dataUsers.size
            }

        })

        for (i in 0..dataUsers.size) {

            if (dataUsers[i].mId == userId) {
                pager_user.setCurrentItem(i)
                break
            }


        }


    }


}