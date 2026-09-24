package com.meno.app.data.repository

import com.meno.app.data.scripture.ScriptureDataSource
import com.meno.app.domain.repository.ScriptureRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ScriptureRepositoryImpl(
    private val scriptureDataSource: ScriptureDataSource
) : ScriptureRepository {
    override fun getVerses(book: String, chapter: Int, startVerse: Int, endVerse: Int): Flow<String> = flow {
        emit(scriptureDataSource.loadVerses(book, chapter, startVerse, endVerse))
    }
}
