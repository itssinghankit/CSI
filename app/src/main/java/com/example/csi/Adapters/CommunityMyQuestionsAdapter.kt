package com.example.csi.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.csi.R
import com.example.csi.modelclasses.CommunityMyQuesDataClassItem


class CommunityMyQuestionsAdapter(val list:List<CommunityMyQuesDataClassItem>, val context: Context): RecyclerView.Adapter<CommunityMyQuestionsAdapter.ViewHolder>() {
   class  ViewHolder(itemView: View,listener:onMyQuesItemClicked) : RecyclerView.ViewHolder(itemView){
       val question = itemView.findViewById<TextView>(R.id.question)
       val edit=itemView.findViewById<ImageView>(R.id.edit)
       val delete=itemView.findViewById<ImageView>(R.id.delete)

       init {
           edit.setOnClickListener{
                listener.onEditClicked(adapterPosition)
           }
           delete.setOnClickListener{
                listener.onDeleteClicked(adapterPosition)
           }
       }
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.my_question_recycler_item,parent,false)
        return ViewHolder(view,onMyQuesItemClicked)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.question.text=list[position].body
    }
}

interface onMyQuesItemClicked{

    fun onEditClicked(position: Int){

    }
    fun onDeleteClicked(position: Int){

    }

}