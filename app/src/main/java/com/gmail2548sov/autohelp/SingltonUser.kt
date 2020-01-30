package com.gmail2548sov.autohelp

import android.util.Log
import java.util.*
import kotlin.collections.ArrayList

object SingltonUser {
    val listUsers: ArrayList<DataUser> = ArrayList()

    init {
        for (i in 0..99) {
            var s = if (i % 2 == 0) true else false
            var user = DataUser(UUID.randomUUID(), "${i + 1}", "+380936377778", "description", Date(), s)
            listUsers.add(user)
        }
    }

    fun getId(id: UUID): DataUser? {
        for (n in listUsers) if (n.mId == id) return n
        return null
    }
}