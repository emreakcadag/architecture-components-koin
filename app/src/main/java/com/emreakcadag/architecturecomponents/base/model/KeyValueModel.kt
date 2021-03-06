package com.emreakcadag.architecturecomponents.base.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

/**
 * Created by Emre Akçadağ on 7.06.2020
 */
data class KeyValueModel<Key : Any?, Value : Any?>(
    @SerializedName("key")
    val key: @RawValue Key?,

    @SerializedName("value")
    val value: @RawValue Value?
) {

    @Parcelize
    data class ViewEntity<Key, Value>(
        val key: @RawValue Key?,
        val value: @RawValue Value?
    ) : Parcelable

    fun toViewEntity(): ViewEntity<Key?, Value?> = ViewEntity(
        key,
        value
    )
}