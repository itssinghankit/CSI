package com.example.csi.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.csi.R
import com.example.csi.modelclasses.AchievementImagesDataClass
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderAdapater(val arrayList: ArrayList<AchievementImagesDataClass>, val context: Context) :
    SliderViewAdapter<SliderAdapater.ViewHolder>() {
    class ViewHolder(itemView: View?) : SliderViewAdapter.ViewHolder(itemView) {
        val achievementimage = itemView!!.findViewById<ImageView>(R.id.achievementImage)
    }

    override fun getCount(): Int {
        return arrayList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        val view = LayoutInflater.from(parent!!.context)
            .inflate(R.layout.achievement_carousel_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder?, position: Int) {
        Glide.with(context).load(arrayList[position].photo).placeholder(R.drawable.fakeimage)
            .into(viewHolder!!.achievementimage)

    }
}