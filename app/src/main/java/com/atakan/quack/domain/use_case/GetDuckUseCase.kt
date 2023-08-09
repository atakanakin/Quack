package com.atakan.quack.domain.use_case

import com.atakan.quack.common.Resource
import com.atakan.quack.data.remote.dto.toDuck
import com.atakan.quack.domain.model.Duck
import com.atakan.quack.domain.repository.DuckRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetDuckUseCase @Inject constructor(
    private val repository: DuckRepository
) {
    operator fun invoke(): Flow<Resource<Duck>> = flow{
        try {
            emit(Resource.Loading())
            val duck = repository.getRandomDuck().toDuck()
            emit(Resource.Success(duck))
        } catch (e : HttpException){
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error occurred."))
        } catch (e : IOException){
            emit(Resource.Error("Could not reach server. Check your connection."))
        }
    }
}