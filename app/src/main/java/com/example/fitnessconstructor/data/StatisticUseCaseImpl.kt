package com.example.fitnessconstructor.data

import com.example.fitnessconstructor.domain.StatisticUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StatisticUseCaseImpl @Inject constructor():StatisticUseCase {

    @Inject
    lateinit var repository: FakeRepository //TODO ("change when working with real database")

    override suspend fun getStatistic() {
        TODO("Not yet implemented")
    }

}