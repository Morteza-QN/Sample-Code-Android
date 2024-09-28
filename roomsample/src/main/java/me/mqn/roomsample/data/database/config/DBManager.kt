package me.mqn.roomsample.data.database.config

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import me.mqn.roomsample.data.database.dao.PersonalInfoDao
import me.mqn.roomsample.data.database.entity.DBPersonalInfo

@Database(
	entities = [
		DBPersonalInfo::class,
	],
	version = DBConstants.DATABASE_VERSION,
	exportSchema = true,
)
@TypeConverters(DBConverters::class)
abstract class DBManager : RoomDatabase() {

	abstract fun personalInfoDao(): PersonalInfoDao
}