package me.mqn.datastoresample.ui

sealed class ViewState<out T> {
	data object Loading : ViewState<Nothing>()
	data class Error(val error: String) : ViewState<Nothing>()
	data class Success<out T>(val result: T) : ViewState<T>()
}