package com.example.csi.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.csi.R
import com.example.csi.modelclasses.EventDataClassItem

class EventsAdapter(val arrayList: List<EventDataClassItem>,val context:Context): RecyclerView.Adapter<EventsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val eventName=itemView.findViewById<TextView>(R.id.eventName)
        val description=itemView.findViewById<TextView>(R.id.domdescription)
        val image=itemView.findViewById<ImageView>(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.events_recycler_items,parent,false)
        val viewHolder=ViewHolder(view)
        return viewHolder

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.eventName.text=arrayList[position].title
        holder.description.text=arrayList[position].description
        Glide.with(context)
            .load(arrayList[position].image)
            .placeholder(R.drawable.fakeimage)
            .into(holder.image)

    }

}