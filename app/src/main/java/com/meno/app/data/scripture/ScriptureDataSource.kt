package com.meno.app.data.scripture

import android.content.Context

class ScriptureDataSource(
    private val context: Context,
    private val parser: ScriptureParser = ScriptureParser()
) {
    fun loadVerses(book: String, chapter: Int, startVerse: Int, endVerse: Int): String {
        // Loads JSON asset from assets/scripture/ilt3/ilt3.json
        return parser.parsePassage(context, book, chapter, startVerse, endVerse)
    }
}
