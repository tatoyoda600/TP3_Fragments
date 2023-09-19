package com.example.tp3_fragments.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_fragments.R
import com.example.tp3_fragments.entities.RecyclerObject
import com.example.tp3_fragments.holders.RecyclerObjectHolder
import com.example.tp3_fragments.listeners.OnViewItemClickedListener

class RecyclerObjectListAdapter(
    private val list: MutableList<RecyclerObject>,
    private val onItemClick: OnViewItemClickedListener
) : RecyclerView.Adapter<RecyclerObjectHolder>() {

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerObjectHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_object_item, parent, false)
        return (RecyclerObjectHolder(view))
    }

    override fun onBindViewHolder(holder: RecyclerObjectHolder, position: Int) {
        val obj = list[position]
        holder.setValor(obj.valor)

        holder.getCardLayout().setOnClickListener{
            onItemClick.onViewItemDetail(obj)
        }
    }
}