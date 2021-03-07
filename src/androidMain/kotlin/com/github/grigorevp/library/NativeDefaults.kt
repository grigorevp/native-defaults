package com.github.grigorevp.library

import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.MODE_PRIVATE


actual class NativeDefaults actual constructor() {

    init {
        require(isContextInitialized()) {"Context was not initialized during the app startup for some reason"}
    }

    companion object {

        @SuppressLint("StaticFieldLeak")
        private lateinit var context: Context

        internal fun setContext(context: Context) {
            Companion.context = context.applicationContext
        }

        private fun isContextInitialized(): Boolean {
            return this::context.isInitialized
        }

    }

    private var preferences = context.getSharedPreferences("Standard", MODE_PRIVATE)

    actual constructor(name: String) : this() {
        require(name != "Standard") {"Name 'Standard' is reserved for NativeDefaults' standard implementation"}
        preferences = context.getSharedPreferences(name, MODE_PRIVATE)
    }

    actual fun setString(key: String, value: String) {
        preferences.edit().putString(key, value).apply()
    }

    actual fun getString(key: String): String? {
        return preferences.getString(key, null)
    }

    actual fun setInt(key: String, value: Int) {
        preferences.edit().putInt(key, value).apply()
    }

    actual fun getInt(key: String): Int? {
        return if (preferences.contains(key)) preferences.getInt(key, 0) else null
    }

    actual fun setFloat(key: String, value: Float) {
        preferences.edit().putFloat(key, value).apply()
    }

    actual fun getFloat(key: String): Float? {
        return if (preferences.contains(key)) preferences.getFloat(key, 0F) else null
    }

    actual fun setBoolean(key: String, value: Boolean) {
        preferences.edit().putBoolean(key, value).apply()
    }

    actual fun getBoolean(key: String): Boolean? {
        return if (preferences.contains(key)) preferences.getBoolean(key, false) else null
    }

    actual fun setStringSet(key: String, set: Set<String>) {
        preferences.edit().putStringSet(key, set).apply()
    }

    actual fun getStringSet(key: String): Set<String>? {
        return if (preferences.contains(key)) preferences.getStringSet(key, emptySet()) else null
    }
    actual fun clearValue(key: String) {
        preferences.edit().remove(key).apply()
    }


}