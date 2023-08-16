package com.example.calculator1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.calculator1.databinding.ListItemBinding
import com.example.calculator1.db.Calculator

class ListItemAdapter: RecyclerView.Adapter<MyViewHolder>() {
    private val equationList=ArrayList<Calculator>()
    fun setList(data:List<Calculator>){
        equationList.clear()
        equationList.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        val binding: ListItemBinding =
            DataBindingUtil.inflate(layoutInflater,R.layout.list_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return equationList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(equationList[position])
    }

}

class MyViewHolder(val binding:ListItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(data:Calculator){
        binding.textView2.text=data.equation
        binding.textView5.text=data.ans.toString()
        binding.textView4.text="="

    }

}