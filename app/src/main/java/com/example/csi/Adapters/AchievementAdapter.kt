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
import com.example.csi.modelclasses.AchievementsDataClassItem

class AchievementAdapter(val arraylist: List<AchievementsDataClassItem>, val context: Context,val listener:onItemClicked) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val FIRST_TYPE = 0
        private const val CENTER_LEFT_TYPE = 1
        private const val CENTER_RIGHT_TYPE = 2
        private const val LAST_LEFT_TYPE = 4
        private const val LAST_RIGHT_TYPE = 5
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0)
            return FIRST_TYPE
        else if (position == arraylist.size - 1) {
            if (position % 2 == 0)
                return LAST_RIGHT_TYPE
            else
                return LAST_LEFT_TYPE
        } else if (position % 2 == 0)
            return CENTER_RIGHT_TYPE
        else
            return CENTER_LEFT_TYPE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            FIRST_TYPE -> FirstViewHolder(
               LayoutInflater.from(parent.context)
                    .inflate(R.layout.achievement_first_recycler_item, parent, false)
            )
            CENTER_LEFT_TYPE -> CenterLeftViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.achievement_center_left_recycleritem, parent, false)
            )
            CENTER_RIGHT_TYPE -> CenterRightViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.achievement_center_right_recycleritem, parent, false)
            )
            LAST_LEFT_TYPE -> LastLeftViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.achievement_last_left_recycleritem, parent, false)
            )
            LAST_RIGHT_TYPE -> LastRightViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.achievement_last_right_recycleritem, parent, false)
            )
            else -> throw java.lang.IllegalArgumentException("Error in CreateViewHolder")

        }
    }

    override fun getItemCount(): Int {
        return arraylist.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is FirstViewHolder -> {
                holder.achievementName.text = arraylist[position].venue
                Glide.with(context)
                    .load(arraylist[position].photo1)
                    .placeholder(R.drawable.fakeimage)
                    .into(holder.achievementImg)
                holder.circleNo.text = (position + 1).toString()
            }
            is CenterRightViewHolder -> {
                holder.achievementName.text = arraylist[position].venue
                Glide.with(context)
                    .load(arraylist[position].photo1)
                    .placeholder(R.drawable.fakeimage)
                    .into(holder.achievementImg)
                holder.circleNo.text = (position + 1).toString()
            }
            is CenterLeftViewHolder -> {
                holder.achievementName.text = arraylist[position].venue
                Glide.with(context)
                    .load(arraylist[position].photo1)
                    .placeholder(R.drawable.fakeimage)
                    .into(holder.achievementImg)
                holder.circleNo.text = (position + 1).toString()
            }
            is LastLeftViewHolder -> {
                holder.achievementName.text = arraylist[position].venue
                Glide.with(context)
                    .load(arraylist[position].photo1)
                    .placeholder(R.drawable.fakeimage)
                    .into(holder.achievementImg)
                holder.circleNo.text = (position + 1).toString()
            }
            is LastRightViewHolder -> {
                holder.achievementName.text = arraylist[position].venue
                Glide.with(context)
                    .load(arraylist[position].photo1)
                    .placeholder(R.drawable.fakeimage)
                    .into(holder.achievementImg)
                holder.circleNo.text = (position + 1).toString()
            }
        }
    }

    //View Holders
    class FirstViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val achievementName = itemView.findViewById<TextView>(R.id.achievementName)
        val achievementImg = itemView.findViewById<ImageView>(R.id.achievementImage)
        val circleNo = itemView.findViewById<TextView>(R.id.circleNo)
    }
    class CenterLeftViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val achievementName = itemView.findViewById<TextView>(R.id.achievementName)
        val achievementImg = itemView.findViewById<ImageView>(R.id.achievementImage)
        val circleNo = itemView.findViewById<TextView>(R.id.circleNo)
    }
    class CenterRightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val achievementName = itemView.findViewById<TextView>(R.id.achievementName)
        val achievementImg = itemView.findViewById<ImageView>(R.id.achievementImage)
        val circleNo = itemView.findViewById<TextView>(R.id.circleNo)
    }
    class LastLeftViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val achievementName = itemView.findViewById<TextView>(R.id.achievementName)
        val achievementImg = itemView.findViewById<ImageView>(R.id.achievementImage)
        val circleNo = itemView.findViewById<TextView>(R.id.circleNo)
    }
    class LastRightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val achievementName = itemView.findViewById<TextView>(R.id.achievementName)
        val achievementImg = itemView.findViewById<ImageView>(R.id.achievementImage)
        val circleNo = itemView.findViewById<TextView>(R.id.circleNo)
    }

    interface onItemClicked{
        fun onAchievementclicked(position:Int){

        }
    }

}