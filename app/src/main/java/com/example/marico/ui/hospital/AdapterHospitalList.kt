package com.example.marico.ui.hospital

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marico.R
import java.io.File

class AdapterHospitalList(val context: Context?) : RecyclerView.Adapter<AdapterHospitalList.MyViewHolder>(){

    private var hospitalList = emptyList<HospitalModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_hospital, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return hospitalList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var users : HospitalModel = hospitalList[position]
        if (context != null) {
            holder.bindItems(hospitalList[position], context)
        }

    }


    internal fun setHospitalList(hospitalList: List<HospitalModel>) {
        this.hospitalList = hospitalList
        notifyDataSetChanged()
    }


    class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

        lateinit var tvTitle: TextView
        lateinit var tvName: TextView
        lateinit var tvAddress: TextView
        lateinit var tvPincode: TextView
        lateinit var tvCity: TextView


        fun bindItems(list : HospitalModel, context: Context){

            tvTitle = itemView.findViewById(R.id.tvId) as TextView
            tvName = itemView.findViewById(R.id.tvName) as TextView
            tvAddress = itemView.findViewById(R.id.tvAddress) as TextView
            tvPincode = itemView.findViewById(R.id.tvPincode) as TextView
            tvCity = itemView.findViewById(R.id.tvCity) as TextView


            val title : String = list.id.toString()
            tvTitle.text = title
            tvName.text = list.name
            tvAddress.text = list.address
            tvPincode.text = list.pincode
            tvCity.text = list.city


        }

    }

}