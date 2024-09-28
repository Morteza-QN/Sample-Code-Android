package me.mqn.datastoresample.datastore.jwt

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import me.mqn.datastoresample.datastore.config.DataStoreAPI

class JwtTokenDataStore @Inject constructor(
	@ApplicationContext context: Context
) : JwtTokenManager, DataStoreAPI(context) {

	companion object {

		private val ACCESS_JWT_KEY = stringPreferencesKey("access_jwt")
		private val REFRESH_JWT_KEY = stringPreferencesKey("refresh_jwt")
	}

	override suspend fun saveAccessJwt(token: String) {
		putPreferenceValue(key = ACCESS_JWT_KEY, value = token)
	}

	override suspend fun saveRefreshJwt(token: String) {
		putPreferenceValue(key = REFRESH_JWT_KEY, value = token)
	}

	override suspend fun getAccessJwt(): String {
		return getPreferenceValue(key = ACCESS_JWT_KEY, defaultValue = "")
	}

	override suspend fun getRefreshJwt(): String {
		return getPreferenceValue(key = REFRESH_JWT_KEY, defaultValue = "")
	}

	override suspend fun clearAllTokens() {
		removePreference(key = ACCESS_JWT_KEY)
		removePreference(key = REFRESH_JWT_KEY)
	}
}