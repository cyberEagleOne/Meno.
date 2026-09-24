package com.meno.app.domain.repository

import kotlinx.coroutines.flow.Flow

interface ScriptureRepository {
    fun getVerses(book: String, chapter: Int, startVerse: Int, endVerse: Int): Flow<String>
}
