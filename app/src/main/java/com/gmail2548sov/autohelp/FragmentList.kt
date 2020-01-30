package com.gmail2548sov.autohelp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gmail2548sov.autohelp.SingltonUser.listUsers
import kotlinx.android.synthetic.main.fragment_list.view.*
import kotlinx.android.synthetic.main.item_user.view.*
import java.security.AccessController

class FragmentList : Fragment() {


    val mUserAdapter: UserAdapter = UserAdapter(listUsers)
    lateinit var myRecyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_list, container, false)
        myRecyclerView = view.myRecyclerView
        myRecyclerView.layoutManager = LinearLayoutManager(context)
        myRecyclerView.setHasFixedSize(true)
        updateUI()
        return view
    }

    fun updateUI() {

        myRecyclerView.adapter = mUserAdapter
        mUserAdapter.notifyDataSetChanged()
   }


    override fun onResume() {
        super.onResume()
        //mUserAdapter.notifyDataSetChanged()
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onDestroy() {
        super.onDestroy()

    }


    inner class UserAdapter(private val points: ArrayList<DataUser>) :
        RecyclerView.Adapter<UserHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            return UserHolder(layoutInflater.inflate(R.layout.item_user, parent, false))
        }

        override fun getItemCount(): Int {
            return points.size
        }

        override fun onBindViewHolder(holder: UserHolder, position: Int) {
            holder.bind(position, points)
            //var viev: View = holder.itemView

        }


    }

    inner class UserHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(position: Int, points: ArrayList<DataUser>) {
            view.imageView2.visibility = if (points[position].isRepair) View.VISIBLE else View.GONE

        }
    }


}