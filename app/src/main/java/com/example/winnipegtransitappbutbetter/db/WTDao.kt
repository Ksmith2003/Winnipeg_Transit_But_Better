package com.example.winnipegtransitappbutbetter.db
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.winnipegtransitappbutbetter.api.Model.cow_data.Route
import com.example.winnipegtransitappbutbetter.api.Model.cow_data.Stop

@Dao
interface WTDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertaAllStops(stops: List<Stop>)

    @Query("SELECT * FROM stops WHERE key = :key")
    fun getStopByKey(key:Int):Stop?

    @Update
    fun updateStopState(stop:Stop)
    // UPDATE movies set isFavourite = new value boolean

    @Query("UPDATE stops SET name= :name WHERE key = :key")
    fun updateStop(key: Int, name:String)

    @Delete
    suspend fun delete(stop:Stop)
    // DELETE from movies where movieId = {MovieId}

    @Query("SELECT * FROM Stops")
    fun getAllStops() : List<Stop>
}