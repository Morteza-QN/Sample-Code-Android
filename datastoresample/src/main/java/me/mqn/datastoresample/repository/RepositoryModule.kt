package me.mqn.datastoresample.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class RepositoryModule {

	@[Binds ActivityRetainedScoped]
	abstract fun bindRepository(impl: RepositoryImpl): Repository
}