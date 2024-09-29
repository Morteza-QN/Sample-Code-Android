package me.mqn.mysamplecode.model

import android.os.Build

data class DeviceInfo(
	val deviceName: String,
	val deviceBrand: String,
	val deviceModel: String,
	val softwareId: String,
) : BaseModel() {

	private val data = mapOf<String, String>(
		"SDK" to Build.VERSION.SDK_INT.toString(),
		"PRODUCT_NAME" to Build.PRODUCT,
		"DEVICE_NAME" to Build.DEVICE,
		"BOARD_NAME" to Build.BOARD,
		"SUPPORTED_ABIS" to Build.SUPPORTED_ABIS.joinToString(),
		"MANUFACTURER" to Build.MANUFACTURER,
		"BRAND" to Build.BRAND,
		"MODEL" to Build.MODEL,
	)
		.map { "${it.key}: ${it.value}" }
		.joinToString("\n")
}