package com.multimoney.multimoney_bussines_logic.di

import com.multimoney.multimoney_bussines_logic.data.MortyRepository
import com.multimoney.multimoney_bussines_logic.domain.GetCharactersUseCase
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initKoin() = startKoin {
    modules(commonModule())
}


private fun commonModule() = module {
    single { MortyRepository() }
    factory { GetCharactersUseCase(get()) }
}

