package com.gmail2548sov.autohelp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CompoundButton
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragnent_user.view.*
import java.util.*

class FragmentUser : Fragment(), CompoundButton.OnCheckedChangeListener {

    var mCallBack: Callbacks? = null


    companion object {
        val ARG_USER_ID = "user_id_com.gmail2548sov.autohelp"
        fun newInstanse(userId: UUID): Fragment {
            val arg = Bundle()
            arg.putSerializable(ARG_USER_ID, userId)
            val fragment = FragmentUser()
            fragment.arguments = arg
            return fragment
        }
    }

    interface Callbacks {
        fun onUserUpdated(dataUser: DataUser?)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragnent_user, container, false)
        val id = arguments?.getSerializable(ARG_USER_ID) as UUID
        val dataUser = SingltonUser.getId(id)
        view.title_datalied.text = dataUser?.mName ?: ""
        val mIsRepair: Boolean = dataUser?.isRepair ?: false
        view.crime_solved.isChecked = mIsRepair

        view.crime_solved.setOnCheckedChangeListener(this)

        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mCallBack = context as Callbacks
    }

    override fun onDestroy() {
        super.onDestroy()
        mCallBack = null
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        val id = arguments?.getSerializable(ARG_USER_ID) as UUID

        when (buttonView!!.isChecked) {

            true -> {
                SingltonUser.getId(id)?.isRepair = true
            }
            false -> {
                SingltonUser.getId(id)?.isRepair = false
            }
        }
        mCallBack?.onUserUpdated(SingltonUser.getId(id))
        Log.d ("up333", "up333")
    }


}