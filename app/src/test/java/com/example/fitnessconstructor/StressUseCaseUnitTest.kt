package com.example.fitnessconstructor

import com.example.fitnessconstructor.data.StressUseCaseImpl
import com.example.fitnessconstructor.database.StressDao
import com.example.fitnessconstructor.domain.StressUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * Test StressUseCase checkResult(...) function
 */
class StressUseCaseUnitTest {

    private lateinit var stressUseCase: StressUseCase

    @Mock
    private lateinit var stressDao: StressDao

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        stressUseCase = StressUseCaseImpl(stressDao)
    }

    @Test
    fun stressUseCase_lowResult() = runBlocking {
        assertEquals(
            "Low POWER",
            stressUseCase.getResult(arrayOf(0, 0, 10))
        )
    }

    @Test
    fun stressUseCase_normanResult() = runBlocking {
        assertEquals(
            "Good POWER",
            stressUseCase.getResult(arrayOf(0, 0, 90))
        )
    }

    @Test
    fun stressUseCase_highResult() = runBlocking {
        assertEquals(
            "High POWER",
            stressUseCase.getResult(arrayOf(0, 0, 150))
        )
    }

    @Test
    fun stressUseCase_excellentResult() = runBlocking {
        assertEquals(
            "Monster POWER",
            stressUseCase.getResult(arrayOf(30, 50, 80))
        )
    }

    @Test
    fun stressUseCase_exceptionIncorrect() {
        assertThrows(IllegalArgumentException::class.java) {
            runBlocking { stressUseCase.getResult(arrayOf(0, 0, -150)) }
        }
    }

    @Test
    fun stressUseCase_exceptionMaxResult() {
        assertThrows(IllegalArgumentException::class.java) {
            runBlocking { stressUseCase.getResult(arrayOf(0, 0, 450)) }
        }
    }
}