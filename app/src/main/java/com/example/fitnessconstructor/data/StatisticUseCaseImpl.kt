package com.example.fitnessconstructor.data

import com.example.fitnessconstructor.domain.StatisticUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StatisticUseCaseImpl @Inject constructor() : StatisticUseCase {

    override suspend fun getStatistic() {
        TODO("Not yet implemented")
    }
}