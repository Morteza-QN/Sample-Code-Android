package me.mqn.mvvm2.data.repository

import me.mqn.mvvm2.domain.repository.IRepository
import me.mqn.mvvm2.domain.source.ILocalDataSource
import me.mqn.mvvm2.domain.source.IRemoteDataSource

class RepositoryImpl(
	private val local: ILocalDataSource,
	private val remote: IRemoteDataSource,
) : IRepository