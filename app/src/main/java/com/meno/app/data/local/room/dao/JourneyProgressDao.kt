package com.meno.app.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.meno.app.data.local.room.entity.JourneyProgressEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface JourneyProgressDao {
    @Query("SELECT * FROM journey_progress WHERE journeyId = :journeyId")
    fun getJourneyProgress(journeyId: String): Flow<JourneyProgressEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(journeyProgress: JourneyProgressEntity)
}
