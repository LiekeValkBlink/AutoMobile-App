package com.example.automobile.screens


import com.example.automobile.data.repositories.CarRepository
import io.mockk.every
import io.mockk.mockkObject
import org.junit.Before
import org.junit.jupiter.api.Assertions.*
import org.mockito.Mock

class CarDetailsViewModelTest {

    @Mock
    private lateinit var viewModel: CarDetailsViewModel


    @Before
    fun setUp() {
        // Mock de CarRepository dependency
        mockkObject(CarRepository)
        every { CarRepository.getCar(any()) } returns null  // Pas deze regel aan op basis van de verwachte output

        // Initialiseer de ViewModel
        viewModel = CarDetailsViewModel()
    }

    @org.junit.jupiter.api.Test
    fun testUpdateCarBrand() {
        val testBrand = "Test Brand"

        viewModel.updateCarBrand(testBrand)

        assertEquals(testBrand, viewModel.carBrand)
    }
}