package me.mqn.datastoresample.usecase

import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import me.mqn.datastoresample.repository.Repository
import me.mqn.datastoresample.usecase.callback.SingleParameterUseCaseCallback

class SaveTokenUseCase @Inject constructor(
	private val repository: Repository
) : SingleParameterUseCaseCallback<String, Flow<Boolean>> {

	override suspend fun execute(params: String): Flow<Boolean> {
		return repository.saveAccessJwt(token = params)
	}
}