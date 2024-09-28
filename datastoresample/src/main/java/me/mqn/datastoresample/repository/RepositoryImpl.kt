package me.mqn.datastoresample.repository

import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import me.mqn.datastoresample.datastore.jwt.JwtTokenManager

@Singleton
class RepositoryImpl @Inject constructor(
	private val jwtTokenManager: JwtTokenManager,
) : Repository {

	override suspend fun getAccessJwt(): String? {
		return jwtTokenManager.getAccessJwt()
	}

	override suspend fun getAccessJwtFlow(): Flow<String?> {
		return jwtTokenManager.getAccessJwtFlow()
	}

	override suspend fun getRefreshJwt(): String? {
		return jwtTokenManager.getRefreshJwt()
	}

	override suspend fun getRefreshJwtFlow(): Flow<String?> {
		return jwtTokenManager.getRefreshJwtFlow()
	}

	override fun saveAccessJwt(token: String): Flow<Boolean> = callbackFlow {
		this.channel.send(jwtTokenManager.saveAccessJwt(token = token))
		awaitClose { close() }
	}

	override fun saveRefreshJwt(refToken: String): Flow<Boolean> = callbackFlow {
		this.channel.send(jwtTokenManager.saveRefreshJwt(token = refToken))
		awaitClose { close() }
	}

	override suspend fun clearAllTokens() {
		jwtTokenManager.clearAllTokens()
	}
}