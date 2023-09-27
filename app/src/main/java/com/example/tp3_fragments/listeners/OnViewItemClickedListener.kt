package com.example.tp3_fragments.listeners

import com.example.tp3_fragments.entities.RecyclerObject
import com.example.tp3_fragments.models.User

interface OnViewItemClickedListener {
    fun onViewItemDetail(obj: RecyclerObject) {}
}