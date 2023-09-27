package com.example.tp3_fragments.entities

import android.os.Parcel
import android.os.Parcelable

class RecyclerObject (
    avatar: String?,
    name: String?
): Parcelable {
    var avatar: String = ""
    var name: String = ""

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    init {
        this.avatar = avatar!!
        this.name = name!!
    }

    override fun writeToParcel(parcel: Parcel, p1: Int) {
        parcel.writeString(avatar)
        parcel.writeString(name)
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