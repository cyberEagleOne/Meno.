package com.meno.app.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.meno.app.data.local.room.entity.ReadingProgressEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ReadingProgressDao {
    @Query("SELECT * FROM reading_progress WHERE readingId = :readingId")
    fun getReadingProgress(readingId: String): Flow<ReadingProgressEntity?>

    @Query("SELECT * FROM reading_progress WHERE isCompleted = 1")
    fun getAllCompletedReadings(): Flow<List<ReadingProgressEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(readingProgress: ReadingProgressEntity)
}
