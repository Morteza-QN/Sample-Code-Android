package me.mqn.roomsample.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import me.mqn.roomsample.data.database.config.DBConstants
import me.mqn.roomsample.data.database.entity.DBPersonalInfo

@Dao
abstract class PersonalInfoDao : BaseDao<DBPersonalInfo> {

	@Query("SELECT * FROM ${DBConstants.PersonalInfoTbl.NAME_TBL}")
	abstract fun getAll(): Flow<List<DBPersonalInfo>>

	@Query("DELETE FROM ${DBConstants.PersonalInfoTbl.NAME_TBL}")
	abstract suspend fun deleteAll()
}