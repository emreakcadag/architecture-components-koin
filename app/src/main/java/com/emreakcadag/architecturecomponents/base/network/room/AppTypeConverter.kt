package com.emreakcadag.architecturecomponents.base.network.room

import androidx.room.TypeConverter
import com.emreakcadag.architecturecomponents.base.extension.fromJson
import com.emreakcadag.architecturecomponents.base.extension.toJson

/**
 * Created by Emre Akçadağ on 10.06.2020
 */

class AppTypeConverter {

    @TypeConverter
    fun jsonStringToList(jsonString: String?) = jsonString.fromJson<List<String?>?>()

    @TypeConverter
    fun listToJsonString(list: List<String?>?) = list.toJson()
}