package com.emreakcadag.architecturecomponents.feature.main.data.repository.local

import androidx.room.*
import com.emreakcadag.architecturecomponents.feature.main.data.response.MainResponse
import com.emreakcadag.architecturecomponents.base.network.room.BaseResponseDao

/**
 * Created by Emre Akçadağ on 7.06.2020
 */
@Dao
abstract class MainResponseDao : BaseResponseDao {

    @Query("SELECT * FROM MainResponse")
    abstract fun getAll(): List<MainResponse?>

    @Query("SELECT * FROM MainResponse WHERE id = 0")
    abstract fun getOne(): MainResponse?

//    @Query("SELECT * FROM app_response WHERE id IN (:ids)")
//    fun loadAllByIds(ids: IntArray?): List<MainResponse?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAll(mainResponse: MainResponse?)

    @Delete
    abstract fun delete(mainResponse: MainResponse?)
}