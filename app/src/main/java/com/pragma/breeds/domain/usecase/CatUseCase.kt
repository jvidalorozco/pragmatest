package com.pragma.breeds.domain.usecase

import com.pragma.breeds.data.model.Cat
import com.pragma.breeds.domain.repository.CatRepository
import com.pragma.breeds.network.Resource
import javax.inject.Inject

class CatUseCase @Inject constructor(
    private val catRepository: CatRepository
) {
    suspend operator fun invoke(): Resource<List<Cat>> {
        return catRepository.getBreeds()
    }
}
