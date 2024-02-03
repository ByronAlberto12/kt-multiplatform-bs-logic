package com.multimoney.multimoney_bussines_logic.data

import com.apollographql.apollo3.ApolloClient
import com.multimoney.GetCharactersQuery
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MortyRepository {

    private val apolloClient = ApolloClient.Builder()
        .serverUrl("https://rickandmortyapi.com/graphql")
        .build()

    suspend fun getCharacters(): Flow<GetCharactersQuery.Characters> {
        val response = apolloClient.query(GetCharactersQuery(1)).execute()
        return flow {  emit(response.dataAssertNoErrors.characters) }
    }
}