package me.mqn.mvvm2.data.mapper

interface AdvanceMapper<I, O> {

	fun from(i: I): O
	fun to(o: O): I
	fun fromList(list: List<I>): List<O> = list.mapNotNull { from(it) }
	fun toList(list: List<O>): List<I> = list.mapNotNull { to(it) }
}