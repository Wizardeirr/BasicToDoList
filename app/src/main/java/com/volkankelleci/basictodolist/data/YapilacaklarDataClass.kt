package com.volkankelleci.basictodolist.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.text.DateFormat

@Entity(tableName = "yapilacaklar_tablosu")
@Parcelize
data class YapilacaklarDataClass(
    val name: String?,
    val tik: Boolean = false,
    val tamamlandi: Boolean = false,
    val currentTime: Long = System.currentTimeMillis(),

    @PrimaryKey(autoGenerate = true)
    val uuid:Int=0

    ) :Parcelable {
    val createdDataFormatted:String
    get()=DateFormat.getDateTimeInstance().format(currentTime)
}