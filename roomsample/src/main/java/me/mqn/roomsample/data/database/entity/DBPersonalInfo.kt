package me.mqn.roomsample.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import me.mqn.roomsample.data.database.config.DBConstants

@Entity(tableName = DBConstants.PersonalInfoTbl.NAME_TBL)
data class DBPersonalInfo(

	@PrimaryKey
	@ColumnInfo(name = DBConstants.PersonalInfoTbl.PERSONAL_ID)
	val personalID: Int? = null, // 1973
	@ColumnInfo(name = DBConstants.PersonalInfoTbl.ID_TBL)
	val userID: Int? = null,
	@ColumnInfo(name = DBConstants.PersonalInfoTbl.FULL_NAME)
	val fullName: String? = null,
	@ColumnInfo(name = DBConstants.PersonalInfoTbl.USERNAME)
	val username: String? = null,
	@ColumnInfo(name = DBConstants.PersonalInfoTbl.STATUS)
	val status: Int? = null, // 1
) : BaseEntity()