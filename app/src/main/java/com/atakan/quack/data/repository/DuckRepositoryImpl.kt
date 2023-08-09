package com.atakan.quack.data.repository

import com.atakan.quack.data.remote.DuckApi
import com.atakan.quack.data.remote.dto.DuckDto
import com.atakan.quack.domain.repository.DuckRepository
import javax.inject.Inject

class DuckRepositoryImpl @Inject constructor(
    private val api : DuckApi
) : DuckRepository {

    override suspend fun getRandomDuck(): DuckDto {
        return api.getRandomDuck()
    }
}