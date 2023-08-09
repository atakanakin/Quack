package com.atakan.quack.presentation.quack

import com.atakan.quack.domain.model.Duck

data class DuckState(
    val isLoading: Boolean = false,
    val duck: Duck = Duck(""),
    val error: String = ""
)
