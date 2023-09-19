package com.example.tp3_fragments.entities

import android.os.Parcel
import android.os.Parcelable

class RecyclerObject (
    valor: String?
): Parcelable {
    var valor: String = ""

    constructor(parcel: Parcel) : this(
        parcel.readString()
    )

    init {
        this.valor = valor!!
    }

    override fun writeToParcel(parcel: Parcel, p1: Int) {
        parcel.writeString(valor)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RecyclerObject> {
        override fun createFromParcel(parcel: Parcel): RecyclerObject {
            return RecyclerObject(parcel)
        }

        override fun newArray(size: Int): Array<RecyclerObject?> {
            return arrayOfNulls(size)
        }
    }
}