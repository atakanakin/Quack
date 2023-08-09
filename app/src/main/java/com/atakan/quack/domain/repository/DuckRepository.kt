package com.atakan.quack.domain.repository

import com.atakan.quack.data.remote.dto.DuckDto

interface DuckRepository {

    suspend fun getRandomDuck() : DuckDto
}