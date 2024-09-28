package me.mqn.roomsample.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import androidx.room.Update
import me.mqn.roomsample.data.database.entity.BaseEntity

/**
 * List of all generic DB actions
 * All use suspend to force kotlin coroutine usage, remove if not required
 */
@Dao
interface BaseDao<T : BaseEntity> {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insert(entity: T)

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insert(entities: List<T>)

	@Update
	suspend fun update(entity: T)

	@Update
	@Transaction
	suspend fun update(entities: List<T>)

	@Delete
	suspend fun delete(entity: T)

	@Delete
	@Transaction
	suspend fun delete(entities: List<T>)
}