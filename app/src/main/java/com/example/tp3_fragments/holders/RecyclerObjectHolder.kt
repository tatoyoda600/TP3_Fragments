package com.example.tp3_fragments.holders

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3_fragments.R

class RecyclerObjectHolder(v: View) : RecyclerView.ViewHolder(v) {
    private var view: View

    init {
        this.view = v
    }

    fun setValor(valor: String) {
        val txt: TextView = view.findViewById(R.id.txt_valor_item)
        txt.text = valor
    }

    fun getCardLayout(): CardView {
        return view.findViewById(R.id.card_package_item)
    }
}