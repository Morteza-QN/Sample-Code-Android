package me.mqn.datastoresample.datastore.config

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import me.mqn.datastoresample.datastore.jwt.JwtTokenDataStore
import me.mqn.datastoresample.datastore.jwt.JwtTokenManager

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

	@[Provides Singleton]
	fun provideJwtTokenManager(@ApplicationContext context: Context): JwtTokenManager = JwtTokenDataStore(context)
}