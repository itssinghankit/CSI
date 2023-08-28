package com.example.csi.Adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.csi.R
import com.example.csi.modelclasses.EventDataClassItem
import com.example.csi.modelclasses.FeedItem

 class FeedAdapter(
    val arrayList: List<FeedItem>,
    val context: Context,
    val listener: OnEventClicked
    ): RecyclerView.Adapter<FeedAdapter.ViewHolder>(){

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val question=itemView.findViewById<TextView>(R.id.question)
            val answer=itemView.findViewById<TextView>(R.id.answer)
            val image=itemView.findViewById<ImageView>(R.id.image)
            val userName=itemView.findViewById<TextView>(R.id.userName)
            val tagLine=itemView.findViewById<TextView>(R.id.tagLine)
            val branch=itemView.findViewById<TextView>(R.id.branch)
            val upvoteCnt=itemView.findViewById<TextView>(R.id.upvoteCnt)
            val upvote=itemView.findViewById<ImageView>(R.id.upvote)
        }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         TODO("Not yet implemented")
     }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         TODO("Not yet implemented")
     }

     override fun getItemCount(): Int {
         TODO("Not yet implemented")
     }
 }
