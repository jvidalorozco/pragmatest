package com.pragma.breeds.ui.presentation.feature.cat

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pragma.breeds.domain.usecase.CatUseCase
import com.pragma.breeds.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatViewModel @Inject constructor(
    private val catUseCase: CatUseCase
) : ViewModel() {

    var state by mutableStateOf(CatScreenState())
        private set

    init {
        getCats()
    }

    private fun getCats() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            catUseCase.invoke().let { response ->
                when (response) {
                    is Resource.Success -> {
                        state = state.copy(
                            response = response.data,
                            isLoading = false,
                            error = null
                        )
                    }
                    is Resource.Error -> {
                        state = state.copy(
                            isLoading = false,
                            error = response.message
                        )
                    }
                }
            }
        }
    }
}