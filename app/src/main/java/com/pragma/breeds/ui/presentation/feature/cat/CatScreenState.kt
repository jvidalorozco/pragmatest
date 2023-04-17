package com.pragma.breeds.ui.presentation.feature.cat

import com.pragma.breeds.data.model.Cat

data class CatScreenState(
    val response: List<Cat>? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)