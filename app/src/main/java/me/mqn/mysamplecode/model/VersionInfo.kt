package me.mqn.mysamplecode.model

data class VersionInfo(
	val appVersion: Int,
	val appName: String,
	val appId: String,
	val isForce: Boolean,
	val type: String,
	val linkDownload: String,
	val logChange: String,
) : BaseModel()