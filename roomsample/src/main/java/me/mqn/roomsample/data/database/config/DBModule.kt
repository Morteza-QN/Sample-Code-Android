package me.mqn.roomsample.data.database.config

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import me.mqn.roomsample.data.database.dao.PersonalInfoDao

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

	@[Provides Singleton]
	fun provideDBManager(@ApplicationContext context: Context): DBManager = DBBuilder.getInstance(context)

	@[Provides Singleton]
	fun providePersonalInfoDao(db: DBManager): PersonalInfoDao = db.personalInfoDao()
}