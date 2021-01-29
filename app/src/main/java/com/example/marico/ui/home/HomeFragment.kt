package com.example.marico.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marico.R
import com.example.marico.ui.hospital.AdapterHospitalList


class HomeFragment : Fragment() {

    private lateinit var adapterHospital : AdapterMapList

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        setHasOptionsMenu(true)

        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerView)
        adapterHospital = AdapterMapList(getContext())
        recyclerView.adapter = adapterHospital
        recyclerView.layoutManager = LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL ,false)


        var list: ArrayList<String> = ArrayList();

        list.add("Masina Hospital");
        list.add("Kem Hospital")
        list.add("JJ Hospital")
        list.add("Reliance Hospital")
        list.add("Global Hospital")

        adapterHospital.setHospitalList(list);


        return root
    }
}