package me.mqn.datastoresample.datastore.config

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
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

	private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "my_datastore_name")

	@[Provides Singleton]
	fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> = context.dataStore

	@[Provides Singleton]
	fun provideJwtTokenManager(dataStore: DataStore<Preferences>): JwtTokenManager = JwtTokenDataStore(dataStore)
}