package com.example.tp3_fragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_fragments.adapters.RecyclerObjectListAdapter
import com.example.tp3_fragments.databinding.FragmentRecyclerListBinding
import com.example.tp3_fragments.entities.RecyclerObject
import com.example.tp3_fragments.listeners.OnViewItemClickedListener
import com.example.tp3_fragments.models.User
import com.example.tp3_fragments.services.ApiInterface
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL : String = "https://api.api-ninjas.com/v1/"

class RecyclerList : Fragment(), OnViewItemClickedListener {
    lateinit var v: View
    lateinit var recycler: RecyclerView
    var list : MutableList<RecyclerObject> = ArrayList<RecyclerObject>()
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerObjectListAdapter: RecyclerObjectListAdapter

    lateinit var binding : FragmentRecyclerListBinding

    companion object {
        fun newInstance() = RecyclerList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRecyclerListBinding.inflate(inflater, container, false)
        // = inflater.inflate(R.layout.fragment_recycler_list, container, false)
        v = binding.root
        //recycler = v.findViewById(R.id.recycler)
        recycler = binding.recycler
        return v
    }

    override fun onStart() {
        super.onStart()
        getData()
        /*
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
        */

        requireActivity()

        recycler.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        recycler.layoutManager = linearLayoutManager
        recycler.adapter = RecyclerObjectListAdapter(list, this)
        /*
        recyclerObjectListAdapter = RecyclerObjectListAdapter(list, this)
        recycler.adapter = recyclerObjectListAdapter
        */
    }

    override fun onViewItemDetail(obj: RecyclerObject) {
        val action = RecyclerListDirections.actionRecyclerListToViewItem(obj)
        this.findNavController().navigate(action)
        Snackbar.make(v, obj.name, Snackbar.LENGTH_SHORT).show()
    }

    fun getData() {
        if (list.size > 0) return

        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        var data = retrofit.getData(0.1f, 10)

        data.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                var data = response.body()!!
                list.clear()
                for (d in data) {
                    list.add(RecyclerObject(d.image_link, d.name))
                }
                recycler.adapter = RecyclerObjectListAdapter(list, this@RecyclerList)
                recycler.hasPendingAdapterUpdates()
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}