package me.mqn.datastoresample.datastore.jwt

import kotlinx.coroutines.flow.Flow

interface JwtTokenManager {

	suspend fun saveAccessJwt(token: String): Boolean
	suspend fun saveRefreshJwt(token: String): Boolean
	suspend fun getAccessJwt(): String?
	suspend fun getAccessJwtFlow(): Flow<String?>
	suspend fun getRefreshJwt(): String?
	suspend fun getRefreshJwtFlow(): Flow<String?>
	suspend fun clearAllTokens()
}