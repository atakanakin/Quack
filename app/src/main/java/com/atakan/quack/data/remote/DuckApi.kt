package com.atakan.quack.data.remote

import com.atakan.quack.data.remote.dto.DuckDto
import retrofit2.http.GET

interface DuckApi {
    @GET("v2/quack")
    suspend fun getRandomDuck() : DuckDto
}