package com.multimoney.multimoney_bussines_logic.domain

import com.multimoney.multimoney_bussines_logic.data.MortyRepository

class GetCharactersUseCase(private val mortyRepository: MortyRepository) {
    suspend fun invoke() = mortyRepository.getCharacters()
}
