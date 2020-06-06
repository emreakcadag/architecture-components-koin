package com.emreakcadag.architecturecomponents.feature.main.data.response

import android.os.Parcelable
import com.emreakcadag.architecturecomponents.network.BaseNetworkResponse
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

/**
 * Created by Emre Akçadağ on 5.06.2020
 */
data class MainResponse(
    val date: String? = null,
    val explanation: String? = null,
    @Json(name = "media_type") val mediaType: String? = null,
    @Json(name = "service_version") val serviceVersion: String? = null,
    val title: String? = null
) : BaseNetworkResponse() {

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