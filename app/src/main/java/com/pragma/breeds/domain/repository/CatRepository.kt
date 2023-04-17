package com.pragma.breeds.domain.repository

import com.pragma.breeds.data.model.Cat
import com.pragma.breeds.network.Resource

interface CatRepository {
    suspend fun getBreeds(): Resource<List<Cat>>
}