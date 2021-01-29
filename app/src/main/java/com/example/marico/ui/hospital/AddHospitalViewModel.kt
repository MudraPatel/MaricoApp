package com.example.marico.ui.hospital

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.marico.DataBaseHandler

class AddHospitalViewModel : ViewModel() {

    fun addDetails(context: Context, model: HospitalModel){
        val db = DataBaseHandler(context)
        db.insertData(model)
    }


    fun getDetails(context: Context) : List<HospitalModel> {
        val db = DataBaseHandler(context)
        var  data = db.readData()
        return data;
    }



}
