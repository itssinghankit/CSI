package com.example.csi.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.csi.Interfaces.OnItemClicked
import com.example.csi.R
import com.example.csi.modelclasses.TeamDataClassItem

class TeamFouthRecyclerAdapter(
    val arrayList: List<TeamDataClassItem>,
    val context: Context,
    val listener: OnItemClicked
) :
    RecyclerView.Adapter<TeamFouthRecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val personName = itemView.findViewById<TextView>(R.id.personName)
        val personDomain = itemView.findViewById<TextView>(R.id.personDomain)
        val personImage = itemView.findViewById<ImageView>(R.id.personImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.team_head_recycler_item, parent, false)
        val viewHolder = ViewHolder(view)
        view.setOnClickListener {
            listener.clickedItem(viewHolder.adapterPosition)
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.text = arrayList[position].name
        holder.personDomain.text = arrayList[position].domain
        Glide.with(context).load(arrayList[position].video).placeholder(R.drawable.fakeimage)
            .into(holder.personImage)
    }

}