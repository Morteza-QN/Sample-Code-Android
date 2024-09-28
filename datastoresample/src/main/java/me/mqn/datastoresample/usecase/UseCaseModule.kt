package me.mqn.datastoresample.usecase

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow
import me.mqn.datastoresample.usecase.callback.NoParameterUseCaseCallback

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

	@[Binds Singleton]
	abstract fun bindGetTokenUseCase(impl: GetTokenUseCase): NoParameterUseCaseCallback<Flow<String?>>
}