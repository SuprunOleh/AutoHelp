package com.gmail2548sov.autohelp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import java.util.*

class ActivitiUser : ActivityUserAbstract() {

    companion object {

        val EXTRA_ID: String = "id_com.gmail2548sov.autohelp"

        fun newIntent(context: Context?, userId: UUID): Intent {
            val intent = Intent(context, ActivitiUser::class.java)
            intent.putExtra(EXTRA_ID, userId)
            return intent
        }
    }

    override fun createFragment(): Fragment {

        var userId = intent.getSerializableExtra(EXTRA_ID) as UUID
        return FragmentUser.newInstanse(userId)
    }

}
