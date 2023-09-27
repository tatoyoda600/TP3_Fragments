package com.example.tp3_fragments.models

import android.os.Parcel
import android.os.Parcelable

data class Cat(
    val image_link: String?,
    val name: String?,
    val length: String?,
    val origin: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(image_link)
        parcel.writeString(name)
        parcel.writeString(length)
        parcel.writeString(origin)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Cat> {
        override fun createFromParcel(parcel: Parcel): Cat {
            return Cat(parcel)
        }

        override fun newArray(size: Int): Array<Cat?> {
            return arrayOfNulls(size)
        }
    }

}
