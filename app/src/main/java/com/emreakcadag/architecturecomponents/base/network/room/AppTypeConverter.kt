package com.emreakcadag.architecturecomponents.base.network.room

import androidx.room.TypeConverter
import com.emreakcadag.architecturecomponents.base.extension.fromJson
import com.emreakcadag.architecturecomponents.base.extension.toJson
import com.emreakcadag.architecturecomponents.base.model.ButtonModel

/**
 * Created by Emre Akçadağ on 10.06.2020
 */

class AppTypeConverter {

    // List<String>?

    @TypeConverter
    fun jsonStringToList(jsonString: String?) = jsonString.fromJson<List<String>?>()

    @TypeConverter
    fun listToJsonString(list: List<String>?) = list.toJson()

    // List<ButtonModel>?

    @TypeConverter
    fun jsonStringToButtonModelList(jsonString: String?) = jsonString.fromJson<List<ButtonModel>?>()

    @TypeConverter
    fun buttonModelListToJsonString(list: List<ButtonModel>?) = list.toJson()
}