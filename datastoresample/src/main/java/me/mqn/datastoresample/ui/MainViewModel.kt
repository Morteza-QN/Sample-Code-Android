package me.mqn.datastoresample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import me.mqn.datastoresample.usecase.GetTokenUseCase
import me.mqn.datastoresample.usecase.SaveTokenUseCase

@HiltViewModel
class MainViewModel @Inject constructor(
	private val getTokenUseCase: GetTokenUseCase,
	private val saveTokenUseCase: SaveTokenUseCase
) : ViewModel() {

	private val _uiStateGetToken: MutableStateFlow<ViewState<String?>> = MutableStateFlow(ViewState.Loading)
	val uiStateGetToken = _uiStateGetToken.asStateFlow()

	private val _uiStateSaveToken: MutableStateFlow<ViewState<Boolean>> = MutableStateFlow(ViewState.Loading)
	val uiStateSaveToken = _uiStateSaveToken.asStateFlow()

	suspend fun getToken() {
		getTokenUseCase.execute().onEach { data ->
			_uiStateGetToken.emit(ViewState.Success(data))
		}.catch {
			_uiStateGetToken.emit(ViewState.Error(it.localizedMessage!!))
		}.launchIn(viewModelScope)
	}

	suspend fun saveToken(token: String) {
		saveTokenUseCase.execute(token).onEach { data ->
			_uiStateSaveToken.emit(ViewState.Success(data))
		}.catch {
			_uiStateSaveToken.emit(ViewState.Error(it.localizedMessage!!))
		}.launchIn(viewModelScope)
	}
}