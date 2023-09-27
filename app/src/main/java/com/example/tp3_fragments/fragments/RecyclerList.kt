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
import com.example.tp3_fragments.listeners.OnViewItemClickedListener
import com.example.tp3_fragments.models.Cat
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
    var list : List<Cat> = ArrayList()
    private lateinit var linearLayoutManager: LinearLayoutManager
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
        recycler = binding.recycler
        return v
    }

    override fun onStart() {
        super.onStart()
        getData()

        requireActivity()

        recycler.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        recycler.layoutManager = linearLayoutManager
        recycler.adapter = RecyclerObjectListAdapter(list, this)
    }

    override fun onViewItemDetail(obj: Cat) {
        val action = RecyclerListDirections.actionRecyclerListToViewItem(obj)
        this.findNavController().navigate(action)
        Snackbar.make(v, obj.name.orEmpty(), Snackbar.LENGTH_SHORT).show()
    }

    fun getData() {
        if (list.size > 0) return

        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        var data = retrofit.getData(0.1f, 10)

        data.enqueue(object : Callback<List<Cat>> {
            override fun onResponse(call: Call<List<Cat>>, response: Response<List<Cat>>) {
                list = response.body()!!
                recycler.adapter = RecyclerObjectListAdapter(list, this@RecyclerList)
                recycler.hasPendingAdapterUpdates()
            }

            override fun onFailure(call: Call<List<Cat>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}