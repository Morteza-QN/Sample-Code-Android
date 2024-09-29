package me.mqn.mvvm2.data.dto

data class Response<T>(
	val data: T,
	val message: String? = null,
)