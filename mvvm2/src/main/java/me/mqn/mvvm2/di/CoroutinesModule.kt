package me.mqn.mvvm2.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

// @Module
// @InstallIn(SingletonComponent::class)
object CoroutinesModule {

	// @Provides
	@IoDispatcher
	fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.IO
}

// @Module
// @InstallIn(SingletonComponent::class)
// internal object DispatchersModule {
//
// 	//  @Provides
// 	//  @Dispatcher(AppDispatchers.IO)
// 	//  fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.IO
// }

// import javax.inject.Qualifier

// @Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class IoDispatcher