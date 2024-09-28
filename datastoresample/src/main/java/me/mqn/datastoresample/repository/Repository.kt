package me.mqn.datastoresample.repository

import kotlinx.coroutines.flow.Flow

interface Repository {

	suspend fun getAccessJwt(): String?
	suspend fun getAccessJwtFlow(): Flow<String?>
	suspend fun getRefreshJwt(): String?
	suspend fun getRefreshJwtFlow(): Flow<String?>
	fun saveAccessJwt(token: String): Flow<Boolean>
	fun saveRefreshJwt(refToken: String): Flow<Boolean>
	suspend fun clearAllTokens()
}