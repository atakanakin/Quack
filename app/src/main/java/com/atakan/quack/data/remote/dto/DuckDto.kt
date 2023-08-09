package com.atakan.quack.data.remote.dto

import com.atakan.quack.domain.model.Duck

data class DuckDto(
    val url: String,
    val message:String
)

fun DuckDto.toDuck() : Duck {
    return Duck(
        url = url
    )
}