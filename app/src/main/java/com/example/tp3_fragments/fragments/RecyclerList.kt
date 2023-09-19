package com.example.tp3_fragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_fragments.R
import com.example.tp3_fragments.adapters.RecyclerObjectListAdapter
import com.example.tp3_fragments.entities.RecyclerObject
import com.example.tp3_fragments.listeners.OnViewItemClickedListener
import com.google.android.material.snackbar.Snackbar

class RecyclerList : Fragment(), OnViewItemClickedListener {
    lateinit var v: View
    lateinit var recycler: RecyclerView
    var list : MutableList<RecyclerObject> = ArrayList<RecyclerObject>()
    private  lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerObjectListAdapter: RecyclerObjectListAdapter

    companion object {
        fun newInstance() = RecyclerList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_recycler_list, container, false)
        recycler = v.findViewById(R.id.recycler)
        return v
    }

    override fun onStart() {
        super.onStart()

        list.clear()

        list.add(RecyclerObject("Hola 1"))
        list.add(RecyclerObject("Hola 2"))
        list.add(RecyclerObject("Hola 3"))
        list.add(RecyclerObject("Hola 4"))
        list.add(RecyclerObject("Hola 5"))
        list.add(RecyclerObject("Hola 6"))
        list.add(RecyclerObject("Hola 7"))
        list.add(RecyclerObject("Hola 8"))
        list.add(RecyclerObject("Hola 9"))

        requireActivity()

        recycler.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        recycler.layoutManager = linearLayoutManager
        recyclerObjectListAdapter = RecyclerObjectListAdapter(list, this)
        recycler.adapter = recyclerObjectListAdapter
    }

    override fun onViewItemDetail(obj: RecyclerObject) {
        val action = RecyclerListDirections.actionRecyclerListToViewItem(obj)
        this.findNavController().navigate(action)
        Snackbar.make(v, obj.valor, Snackbar.LENGTH_SHORT).show()
    }
}