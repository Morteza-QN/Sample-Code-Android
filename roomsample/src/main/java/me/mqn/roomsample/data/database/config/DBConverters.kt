package me.mqn.roomsample.data.database.config

import androidx.room.TypeConverter
import java.sql.Date

class DBConverters {

	@TypeConverter
	fun toString(list: List<String>): String = list.joinToString(",")

	@TypeConverter
	fun fromString(data: String): List<String> = data.split(",").map { it.trim() }

	@TypeConverter
	fun toDate(timestamp: Long): Date = Date(timestamp)

	@TypeConverter
	fun toTimestamp(date: Date): Long = date.time

	@TypeConverter
	fun toJson(data: Any): String = TODO("Not yet implemented")

	@TypeConverter
	fun fromJson(data: String): Any = TODO("Not yet implemented")
}