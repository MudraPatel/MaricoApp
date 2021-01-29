package com.example.marico.ui.hospital

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marico.R
import com.example.marico.ui.image.CaptureImageViewModel


class AddHospitalFragment : Fragment() {

    companion object {
        fun newInstance() = AddHospitalFragment()
    }

    private lateinit var viewModel: AddHospitalViewModel
    private lateinit var adapterHospital : AdapterHospitalList

    lateinit var btnInsert: Button;
    lateinit var editTextName: TextView;
    lateinit var editTextAddress: TextView;
    lateinit var editTextPincode: TextView;
    lateinit var editTextCity: TextView;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root =  inflater.inflate(R.layout.fragment_add_hospital, container, false)
        btnInsert  =root.findViewById(R.id.btnInsert);
        editTextName =  root.findViewById(R.id.editTextName);
        editTextAddress = root.findViewById(R.id.editTextAddress);
        editTextPincode = root.findViewById(R.id.editTextPincode);
        editTextCity = root.findViewById(R.id.editTextCity);

        val context = this
        btnInsert.setOnClickListener {
            if (editTextName.text.toString().isNotEmpty() && editTextAddress.text.toString()
                    .isNotEmpty() &&
                editTextPincode.text.toString().isNotEmpty() && editTextCity.text.toString()
                    .isNotEmpty()
            ) {
                val hospitalModel =
                    HospitalModel(0, editTextName.text.toString(), editTextAddress.text.toString(), editTextPincode.text.toString(), editTextCity.text.toString())
                getContext()?.let { it1 -> viewModel.addDetails(it1, hospitalModel) };
                clearField()
                var list: List<HospitalModel>? =
                    getContext()?.let { it1 -> viewModel.getDetails(it1) };

                if (list != null) {
                    adapterHospital.setHospitalList(list)
                };

            } else {
                Toast.makeText(getContext(), "Please Fill All Data's", Toast.LENGTH_SHORT).show()

            }
        }

        setHasOptionsMenu(true)

        val recyclerView = root.findViewById<RecyclerView>(R.id.recyclerView)
        adapterHospital = AdapterHospitalList(getContext())
        recyclerView.adapter = adapterHospital
        recyclerView.layoutManager = LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL ,false)

        return root;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel =ViewModelProvider(this).get(AddHospitalViewModel::class.java)


        var list: List<HospitalModel>? = context?.let { viewModel.getDetails(it) };

        if (list != null) {
            adapterHospital.setHospitalList(list)
        };



        // TODO: Use the ViewModel
    }

    private fun clearField() {
        editTextName.text = ""
        editTextAddress.text = ""
        editTextPincode.text = ""
        editTextCity.text = ""
    }

}
