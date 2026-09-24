package com.meno.app.navigation

object Routes {
    const val ONBOARDING = "onboarding"
    const val HOME = "home"
    const val JOURNEY_DETAIL = "journey/{journeyId}"
    const val READING = "reading/{readingId}"
    const val COMPLETION = "completion"
    const val PROGRESS = "progress"
    const val PROFILE = "profile"
    const val REMINDER_SETTINGS = "reminder_settings"

    fun journeyDetail(journeyId: String): String = "journey/$journeyId"
    fun reading(readingId: String): String = "reading/$readingId"
}
