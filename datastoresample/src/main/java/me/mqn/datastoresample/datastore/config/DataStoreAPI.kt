package me.mqn.datastoresample.datastore.config

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import java.io.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

abstract class DataStoreAPI(context: Context) {

	private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "my_datastore")
	private val dataSource = context.applicationContext.dataStore

	protected suspend fun <T> putPreferenceValue(key: Preferences.Key<T>, value: T) {
		dataSource.edit { preferences ->
			preferences[key] = value
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

	suspend fun clearAllPreference() {
		dataSource.edit { preferences ->
			preferences.clear()
		}
	}
}