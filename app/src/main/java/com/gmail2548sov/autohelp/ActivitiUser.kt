package com.gmail2548sov.autohelp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class ActivitiUser : ActivityUserAbstract() {

    override fun createFragment(): Fragment {
        return FragmentUser()
    }

}
