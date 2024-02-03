package com.multimoney.multimoney_bussines_logic.domain

import com.apollographql.apollo3.api.Optional
import com.multimoney.multimoney_bussines_logic.data.MortyRepository

class GetCharactersUseCase(private val mortyRepository: MortyRepository) {
    suspend fun invoke() = mortyRepository.getCharacters(Optional.present(0))
}
