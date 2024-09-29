package me.mqn.mvvm2.di

// @Module
// @InstallIn(SingletonComponent::class)
object DataSourceModule {

	// @[Provides Singleton]
	// fun provideRemoteDataSource(
	//     apiService: ApiService,
	// ): RemoteDataSource = RemoteDataSourceImpl(
	//     apiService = apiService,
	// )

	// @[Provides Singleton]
	// fun provideLocalDataSource(
	//     userDao: UserDao,
	//     @IoDispatcher ioDispatcher: CoroutineDispatcher,
	// ): LocalDataSource = LocalDataSourceImpl(
	//     userDao = userDao,
	//     io = ioDispatcher,
	// )
}