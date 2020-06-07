package com.emreakcadag.architecturecomponents.feature.main.data.repository.local

import androidx.room.*
import com.emreakcadag.architecturecomponents.feature.main.data.response.MainResponse

/**
 * Created by Emre Akçadağ on 7.06.2020
 */
@Dao
interface MainResponseDao {

    @Query("SELECT * FROM main_response")
    fun getAll(): List<MainResponse?>

//    @Query("SELECT * FROM main_response WHERE id IN (:ids)")
//    fun loadAllByIds(ids: IntArray?): List<MainResponse?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg mainResponse: MainResponse?)

    @Delete
    fun delete(mainResponse: MainResponse?)
}