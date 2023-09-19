package com.example.tp3_fragments.listeners

import com.example.tp3_fragments.entities.RecyclerObject

interface OnViewItemClickedListener {
    fun onViewItemDetail(obj: RecyclerObject) {}
}