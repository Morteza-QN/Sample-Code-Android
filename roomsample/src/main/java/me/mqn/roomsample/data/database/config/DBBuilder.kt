package me.mqn.roomsample.data.database.config

import android.content.Context
import androidx.room.Room

object DBBuilder {

	@Volatile
	private var INSTANCE: DBManager? = null

	fun getInstance(context: Context): DBManager =
		INSTANCE ?: synchronized(DBManager::class) {
			buildRoomDB(context = context).also {
				INSTANCE = it
			}
		}

	private fun buildRoomDB(context: Context): DBManager {
		return Room.databaseBuilder(
			context = context.applicationContext,
			klass = DBManager::class.java,
			name = DBConstants.DATABASE_NAME,
		)
			.fallbackToDestructiveMigration()
			.build()
	}
}