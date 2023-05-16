package com.example.csi.Adapters
import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.csi.R
import com.example.csi.databinding.DomainRecyclerBinding
import com.example.csi.modelclasses.Domains



class DomainsAdapter(val arrayList: ArrayList<Domains>): RecyclerView.Adapter<DomainsAdapter.ViewHolder>() {
    class ViewHolder( val binding: DomainRecyclerBinding) : RecyclerView.ViewHolder(binding.root){
        val DomainsName=itemView.findViewById<TextView>(R.id.domainName)
        val domdescription=itemView.findViewById<TextView>(R.id.domdescription)
        val domainImage=itemView.findViewById<ImageView>(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=DomainRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.DomainsName.text=arrayList[position].domainName
        holder.domdescription.text=arrayList[position].domaindescription
        holder.domainImage.setImageResource(arrayList[position].domainsImageResourceId!!)
    }

}