package com.example.csi.Adapters
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.csi.R
import com.example.csi.modelclasses.Domains



class DomainsAdapter(val arrayList: ArrayList<Domains>): RecyclerView.Adapter<DomainsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val DomainsName=itemView.findViewById<TextView>(R.id.domainName)
        val domdescription=itemView.findViewById<TextView>(R.id.domdescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.domain_recycler,parent,false)
        val viewHolder=ViewHolder(view)
        return viewHolder

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.DomainsName.text=arrayList[position].DomainsName
        holder.domdescription.text=arrayList[position].domdescription

    }

}