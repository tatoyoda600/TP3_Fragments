package com.example.tp3_fragments.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_fragments.R
import com.example.tp3_fragments.databinding.RecyclerObjectItemBinding
import com.example.tp3_fragments.holders.RecyclerObjectHolder
import com.example.tp3_fragments.listeners.OnViewItemClickedListener
import com.example.tp3_fragments.models.Cat

class RecyclerObjectListAdapter(
    private val list: List<Cat>,
    private val onItemClick: OnViewItemClickedListener
) : RecyclerView.Adapter<RecyclerObjectHolder>() {

    override fun getItemCount() = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerObjectHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_object_item, parent, false)
        val binding = RecyclerObjectItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return (RecyclerObjectHolder(binding))
    }

    override fun onBindViewHolder(holder: RecyclerObjectHolder, position: Int) {
        val obj = list[position]
        holder.setAvatar(obj.image_link.orEmpty())
        holder.setName(obj.name.orEmpty())

        holder.getCardLayout().setOnClickListener{
            onItemClick.onViewItemDetail(obj)
        }
    }
}