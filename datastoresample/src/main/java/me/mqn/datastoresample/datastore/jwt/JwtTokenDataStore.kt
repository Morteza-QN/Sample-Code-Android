package me.mqn.datastoresample.datastore.jwt

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import me.mqn.datastoresample.datastore.config.DataStoreAPI

class JwtTokenDataStore @Inject constructor(
	dataSource: DataStore<Preferences>
) : JwtTokenManager, DataStoreAPI(dataSource) {

	companion object {

		private val ACCESS_JWT_KEY = stringPreferencesKey("access_jwt")
		private val REFRESH_JWT_KEY = stringPreferencesKey("refresh_jwt")
	}

	override suspend fun saveAccessJwt(token: String): Boolean = putPreferenceValue(key = ACCESS_JWT_KEY, value = token)
	override suspend fun saveRefreshJwt(token: String): Boolean = putPreferenceValue(key = REFRESH_JWT_KEY, value = token)

	override suspend fun getAccessJwt(): String = getPreferenceValue(key = ACCESS_JWT_KEY, defaultValue = "")
	override suspend fun getRefreshJwt(): String = getPreferenceValue(key = REFRESH_JWT_KEY, defaultValue = "")

	override suspend fun getAccessJwtFlow(): Flow<String?> = getPreferenceFlow(key = ACCESS_JWT_KEY, defaultValue = "")
	override suspend fun getRefreshJwtFlow(): Flow<String?> = getPreferenceFlow(key = REFRESH_JWT_KEY, defaultValue = "")

	override suspend fun clearAllTokens() {
		removePreference(key = ACCESS_JWT_KEY)
		removePreference(key = REFRESH_JWT_KEY)
	}
}