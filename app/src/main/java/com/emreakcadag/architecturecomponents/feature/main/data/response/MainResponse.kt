package com.emreakcadag.architecturecomponents.feature.main.data.response

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.emreakcadag.architecturecomponents.base.network.BaseResponse
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * Created by Emre Akçadağ on 5.06.2020
 */
@Entity(tableName = "MainResponse")
data class MainResponse(
    val date: String? = null,
    val explanation: String? = null,
    @Json(name = "media_type") val mediaType: String? = null,
    @Json(name = "service_version") val serviceVersion: String? = null,
    val title: String? = null,
    @PrimaryKey(autoGenerate = false) val id: Int = 0
) : BaseResponse() {

    /**
     * ViewEntity of MainResponse
     */
    @Parcelize
    data class ViewEntity(
        val date: String?,
        val explanation: String?,
        val mediaType: String?,
        val serviceVersion: String?,
        val title: String?,
        val url: String?
    ) : Parcelable

    /**
     * MainResponse To ViewEntity
     */
    fun toViewEntity() = ViewEntity(
        date,
        explanation,
        mediaType,
        serviceVersion,
        title,
        url
    )
}