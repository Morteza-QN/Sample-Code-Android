package me.mqn.mvvm2.data.source

import kotlinx.coroutines.CoroutineDispatcher
import me.mqn.mvvm2.di.IoDispatcher
import me.mqn.mvvm2.domain.source.ILocalDataSource

// @Inject
class LocalDataSourceImpl constructor(
	// todo add all Dao
	@IoDispatcher
	private val io: CoroutineDispatcher,
) : ILocalDataSource