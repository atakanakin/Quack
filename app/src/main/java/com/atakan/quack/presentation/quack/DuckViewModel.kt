package com.atakan.quack.presentation.quack


import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.atakan.quack.common.Resource
import com.atakan.quack.domain.model.Duck
import com.atakan.quack.domain.use_case.GetDuckUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DuckViewModel @Inject constructor(
    private val getDuckUseCase: GetDuckUseCase
) : ViewModel(){

    private val _state = mutableStateOf(DuckState())
    val state: State<DuckState> = _state

    init{
        getDuck()
    }

    fun refreshDuck() {
        getDuck()
    }

    private fun getDuck(){
        getDuckUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = DuckState(duck = result.data ?: Duck(""))
                }
                is Resource.Error -> {
                    _state.value = DuckState(
                        error = result.message ?: "Unexpected error occurred."
                    )
                }
                is Resource.Loading -> {
                    _state.value = DuckState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}