package com.multimoney.multimoney_bussines_logic.data

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional
import com.multimoney.GetCharactersQuery
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MortyRepository {

    private val apolloClient = ApolloClient.Builder()
        .serverUrl("https://rickandmortyapi.com/graphql")
        .build()

    suspend fun getCharacters(page: Optional<Int>): Flow<GetCharactersQuery.Characters> {
        val response = apolloClient.query(GetCharactersQuery(page)).execute()
        return flow {  emit(response.dataOrThrow().characters) }
    }
}