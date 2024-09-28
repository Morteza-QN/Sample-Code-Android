package me.mqn.mvvm.data.mapper

interface Mapper<DOMAIN, DATA> {

	fun toDomain(data: DATA): DOMAIN
	fun toData(domain: DOMAIN): DATA
}