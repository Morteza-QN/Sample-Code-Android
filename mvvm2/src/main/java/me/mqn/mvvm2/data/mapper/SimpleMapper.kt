package me.mqn.mvvm2.data.mapper

interface SimpleMapper<F, T> {

	fun map(from: F): T
}