package com.example.marico.ui.home

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marico.R
import java.io.File

class AdapterMapList(val context: Context?) : RecyclerView.Adapter<AdapterMapList.MyViewHolder>(){

    private var hospitalList = emptyList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_hospital_name, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return hospitalList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var name : String = hospitalList[position]
        if (context != null) {
            holder.bindItems(hospitalList[position], context)
        }

//        holder.tvTitle.setOnClickListener(this)

        holder.tvTitle.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                //your implementation goes here
                var addr:String  = name
                val map = "http://maps.google.co.in/maps?q="+name
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(map))
                intent.setPackage("com.google.android.apps.maps");
                context?.startActivity(intent)
            }
        })

    }


    internal fun setHospitalList(hospitalList: List<String>) {
        this.hospitalList = hospitalList
        notifyDataSetChanged()
    }


    class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

        lateinit var tvTitle: TextView


        fun bindItems(list : String, context: Context){

            tvTitle = itemView.findViewById(R.id.tvId) as TextView


            val title : String = list.toString()
            tvTitle.text = title


        }

    }

}