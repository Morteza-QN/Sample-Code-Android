package me.mqn.mysamplecode.utils

fun String.capitalizeFirstLetter(): String {
	return this.substring(0, 1).uppercase() + this.substring(1)
}