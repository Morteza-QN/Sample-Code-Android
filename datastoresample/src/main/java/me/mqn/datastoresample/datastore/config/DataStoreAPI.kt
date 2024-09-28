package me.mqn.datastoresample.datastore.config

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import java.io.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

abstract class DataStoreAPI(private val dataSource: DataStore<Preferences>) {

	protected suspend fun <T> putPreferenceValue(key: Preferences.Key<T>, value: T): Boolean {
		return try {
			dataSource.edit { preferences ->
				preferences[key] = value
			}
			true
		} catch (e: Exception) {
			false
		}
	}

	protected suspend fun <T> getPreferenceValue(key: Preferences.Key<T>, defaultValue: T): T =
		dataSource.data.first()[key] ?: defaultValue

	protected suspend fun <T> getPreferenceFlow(key: Preferences.Key<T>, defaultValue: T): Flow<T> =
		dataSource.data.catch { exception ->
			if (exception is IOException) {
				emit(emptyPreferences())
			} else {
				throw exception
			}
		}.map { preferences ->
			val result = preferences[key] ?: defaultValue
			result
		}

	protected suspend fun <T> removePreference(key: Preferences.Key<T>) {
		dataSource.edit { preferences ->
			preferences.remove(key)
		}
	}

	protected suspend fun clearAllPreference() {
		dataSource.edit { preferences ->
			preferences.clear()
		}
	}
}