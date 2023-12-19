package com.example.automobile.data.repositories

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.lang.ref.WeakReference

private val Context.localStorageDataStore: DataStore<Preferences> by preferencesDataStore(
    name = "local_storage"
)

/**
 * LocalStorageRepository provides data persistence using a custom Preference DataStore.
 */
object LocalStorageRepository {
    var context: WeakReference<Context> = WeakReference(null)

    object Keys {
        val AUTH_JWT = stringPreferencesKey("auth_jwt")
    }

    suspend fun <T> loadPreference(key: Preferences.Key<T>): T? {
        val currentContext: Context = context.get() ?: return null

        return currentContext.localStorageDataStore.data
            .map { preferences -> preferences[key] }
            .first()
    }

    suspend fun <T> savePreference(key: Preferences.Key<T>, value: T) {
        val currentContext: Context? = context.get()

        currentContext?.localStorageDataStore?.edit { preferences ->
            preferences[key] = value
        }
    }

    suspend fun <T> clearPreference(key: Preferences.Key<T>) {
        val currentContext: Context? = context.get()

        currentContext?.localStorageDataStore?.edit {
            clearPreference(key)
        }
    }
}