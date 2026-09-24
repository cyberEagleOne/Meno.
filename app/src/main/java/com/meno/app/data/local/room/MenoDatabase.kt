package com.meno.app.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.meno.app.data.local.room.dao.JourneyProgressDao
import com.meno.app.data.local.room.dao.ReadingProgressDao
import com.meno.app.data.local.room.dao.UserProgressDao
import com.meno.app.data.local.room.entity.JourneyProgressEntity
import com.meno.app.data.local.room.entity.ReadingProgressEntity
import com.meno.app.data.local.room.entity.UserProgressEntity

@Database(
    entities = [
        UserProgressEntity::class,
        ReadingProgressEntity::class,
        JourneyProgressEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class MenoDatabase : RoomDatabase() {
    abstract fun userProgressDao(): UserProgressDao
    abstract fun readingProgressDao(): ReadingProgressDao
    abstract fun journeyProgressDao(): JourneyProgressDao
}
