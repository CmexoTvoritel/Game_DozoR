package com.example.gamedozor.utils

import android.content.SharedPreferences

fun SharedPreferences.saveString(key: String, value: String?) {
    edit().putString(key, value).apply()
}

fun SharedPreferences.saveBoolean(key: String, value: Boolean) {
    edit().putBoolean(key, value).apply()
}

fun SharedPreferences.saveInt(key: String, value: Int) {
    edit().putInt(key, value).apply()
}