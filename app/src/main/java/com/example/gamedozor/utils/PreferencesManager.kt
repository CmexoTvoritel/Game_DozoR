package com.example.gamedozor.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesManager @Inject constructor(
    @ApplicationContext context: Context
) {
    companion object {
        private const val PREFERENCES_USER_AUTH_KEY = "PREFERENCES_USER_AUTH_KEY"
        private const val PREFERENCES_ALWAYS_LOGIN = "PREFERENCES_ALWAYS_LOGIN"
        private const val PREFERENCES_USER_ID = "PREFERENCES_USER_ID"
    }

    private var preferencesManager: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)

    var authKey: String?
        get() = preferencesManager.getString(PREFERENCES_USER_AUTH_KEY, null)
        set(value) = preferencesManager.saveString(PREFERENCES_USER_AUTH_KEY, value = value)

    var isAlwaysLogin: Boolean
        get() = preferencesManager.getBoolean(PREFERENCES_ALWAYS_LOGIN, false)
        set(value) = preferencesManager.saveBoolean(PREFERENCES_ALWAYS_LOGIN, value = value)

    var userID: Int
        get() = preferencesManager.getInt(PREFERENCES_USER_ID, -1)
        set(value) = preferencesManager.saveInt(PREFERENCES_USER_ID, value = value)
}