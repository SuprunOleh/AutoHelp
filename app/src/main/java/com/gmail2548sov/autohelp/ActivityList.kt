package com.gmail2548sov.autohelp

import androidx.fragment.app.Fragment

class ActivityList: ActivityUserAbstract() {



    override fun createFragment(): Fragment {
        return FragmentList()
    }
}