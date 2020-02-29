package com.gmail2548sov.autohelp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gmail2548sov.autohelp.SingltonUser.listUsers
import kotlinx.android.synthetic.main.fragment_list.view.*
import kotlinx.android.synthetic.main.fragnent_user.view.*
import kotlinx.android.synthetic.main.item_user.view.*
import java.security.AccessController
import java.util.*
import kotlin.collections.ArrayList

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


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        Log.d ("ddd","999")
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.map, menu)

    }


    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_map_view -> {
            Log.d ("ddd","777")

            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun onResume() {
        super.onResume()
        updateUI()
        //mUserAdapter.notifyDataSetChanged()
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onDestroy() {
        super.onDestroy()

    }


    inner class UserAdapter(private val dataUsers: ArrayList<DataUser>) : RecyclerView.Adapter<UserHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            return UserHolder(layoutInflater.inflate(R.layout.item_user, parent, false))
        }

        override fun getItemCount(): Int {
            return dataUsers.size
        }

        override fun onBindViewHolder(holder: UserHolder, position: Int) {

            val dataUser = dataUsers[position]
            Log.d ("eee", "${position}2")
            holder.bind(dataUser)
            //var viev: View = holder.itemView

        }


    }

    inner class UserHolder(val view: View) : RecyclerView.ViewHolder(view), OnClickListener
    {

        init {

            view.setOnClickListener(this)
        }

        lateinit var mdataUser: DataUser



        fun bind(dataUser:DataUser) {
            mdataUser = dataUser
            view.imageView2.visibility = if (mdataUser.isRepair) View.VISIBLE else View.GONE
            view.item_data.text = Date().toString()
            val name = "${R.string.user_name} #${mdataUser.mName}"
            view.item_list.text = name

        }

        override fun onClick(v: View?) {
            val intent = ActivityUserPager.newIntent(context, mdataUser.mId)
            startActivity(intent)
            Toast.makeText(context,"Hi!!!",Toast.LENGTH_SHORT).show()
        }
    }


}