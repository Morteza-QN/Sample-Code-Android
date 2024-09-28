package me.mqn.datastoresample.usecase

import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import me.mqn.datastoresample.repository.Repository
import me.mqn.datastoresample.usecase.callback.NoParameterUseCaseCallback

class GetTokenUseCase @Inject constructor(
	private val repository: Repository
) : NoParameterUseCaseCallback<Flow<String?>> {

	override suspend fun execute(): Flow<String?> {
		return repository.getAccessJwtFlow()
	}
}