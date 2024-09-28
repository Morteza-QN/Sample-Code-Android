package me.mqn.datastoresample.usecase.callback

interface SingleParameterUseCaseCallback<In, Out> {

	suspend fun execute(params: In): Out
}