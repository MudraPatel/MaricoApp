package com.example.marico

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.marico.ui.hospital.HospitalModel

val DATABASENAME = "MY DATABASE"
val TABLENAME = "Hospital"
val COL_ID = "id"
val COL_NAME = "name"
val COL_ADDRESS = "address"
val COL_PINCODE = "pincode"
val COL_CITY= "city"
class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASENAME, null,
    1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLENAME + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_NAME + " VARCHAR(256)," + COL_ADDRESS + " VARCHAR(256)," + COL_PINCODE + " VARCHAR(256)," + COL_CITY + " VARCHAR(256))"
        db?.execSQL(createTable)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //onCreate(db);
    }
    fun insertData(hosp: HospitalModel) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_NAME, hosp.name)
        contentValues.put(COL_ADDRESS, hosp.address)
        contentValues.put(COL_PINCODE, hosp.pincode)
        contentValues.put(COL_CITY, hosp.city)
        val result = database.insert(TABLENAME, null, contentValues)
        if (result == (0).toLong()) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
        }
    }
    fun readData(): MutableList<HospitalModel> {
        val list: MutableList<HospitalModel> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLENAME"
        val result = db.rawQuery(query, null)
        if (result.moveToFirst()) {
            do {
                val id:Int = result.getString(result.getColumnIndex(COL_ID)).toInt()
                val name:String = result.getString(result.getColumnIndex(COL_NAME))
                val address:String = result.getString(result.getColumnIndex(COL_ADDRESS))
                val pincode:String = result.getString(result.getColumnIndex(COL_PINCODE))
                val city:String = result.getString(result.getColumnIndex(COL_CITY))
                val hosp = HospitalModel(id,name,address, pincode, city)
                list.add(hosp)
            }
            while (result.moveToNext())
        }
        return list
    }
}