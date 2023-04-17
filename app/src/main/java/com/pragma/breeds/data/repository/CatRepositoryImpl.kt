package com.pragma.breeds.data.repository

import android.util.Log
import com.pragma.breeds.data.model.Cat
import com.pragma.breeds.data.remote.ApiCats
import com.pragma.breeds.domain.repository.CatRepository
import com.pragma.breeds.network.Constants.API_KEY
import com.pragma.breeds.network.Constants.ERROR_GENERIC
import com.pragma.breeds.network.Resource
import javax.inject.Inject

class CatRepositoryImpl @Inject constructor(
    private val apiCats: ApiCats
): CatRepository {
    override suspend fun getBreeds(): Resource<List<Cat>> {
        return try {
            Resource.Success(data = apiCats.getBreeds(API_KEY).body())
        } catch(exception: Exception) {
            Resource.Error(ERROR_GENERIC)
        }
    }
}