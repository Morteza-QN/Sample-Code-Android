package me.mqn.datastoresample.usecase.callback

interface NoParameterUseCaseCallback<Out> {

	suspend fun execute(): Out
}