package com.example.csi.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.csi.R
import com.example.csi.modelclasses.TeamMemberDataClass

class TeamFouthHeadRecyclerAdapter(val arrayList: ArrayList<TeamMemberDataClass>) :
    RecyclerView.Adapter<TeamFouthHeadRecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val personName = itemView.findViewById<TextView>(R.id.personName)
        val personDomain = itemView.findViewById<TextView>(R.id.personDomain)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.team_head_recycler_item, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.text = arrayList[position].personName
        holder.personDomain.text = arrayList[position].personDomain
    }

}