package com.example.calculator1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calculator1.databinding.ActivityMainBinding
import com.example.calculator1.domain.AddEquationUseCase
import com.example.calculator1.domain.DeleteEquationsUseCase
import com.example.calculator1.presentation.MainActivityViewModel
import com.example.calculator1.presentation.MainActivityViewModelFactory
import com.example.calculator1.presentation.di.Injector
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MainActivityViewModelFactory
    lateinit var viewModel:MainActivityViewModel
    private lateinit var binding:ActivityMainBinding
    lateinit var listItemAdapter: ListItemAdapter
    lateinit var adapter:ListItemAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        (application as Injector).createCalculatorSubComponent()
            .inject(this)

        viewModel = ViewModelProvider(this,factory).get(MainActivityViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        //Set up for equation update
        viewModel.currentInput.observe(this,{
            val editText= Editable.Factory.getInstance().newEditable(it)
            binding.textView.text=editText
        })
        //setup for answer update
        viewModel.currentAns.observe(this,{
            binding.textView3.text= it.toString()
        })



        // Button click listener to open the drawer
        binding.buttonhistory.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
            initRecyclerView()

        }
    }
    fun initRecyclerView(){
        binding.recyclerViewNavigation.layoutManager=LinearLayoutManager(this)
        adapter= ListItemAdapter()
        binding.recyclerViewNavigation.adapter=adapter
        displaydata()
    }
    fun displaydata(){
        val responseData=viewModel.getEquations()
        Log.i("Mytag",responseData.toString())
        responseData.observe(this, Observer {
            if(it!=null){
                listItemAdapter.setList(
                    it
                )
                listItemAdapter.notifyDataSetChanged()

            }
            else{
                Toast.makeText(applicationContext,"No Data Available", Toast.LENGTH_LONG).show()
            }})
    }


}

