package com.example.automobile.screens

import com.example.automobile.data.models.Car
import com.example.automobile.data.repositories.CarRepository
import com.squareup.moshi.Json
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

@ExperimentalCoroutinesApi
class CarSettingsViewModelTest {
    private lateinit var viewModel: CarSettingsViewModel
    private val carRepositoryMock = mockk<CarRepository>()

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        coEvery { carRepositoryMock.getCar(any()) } returns Car(
            id = 1,
            licencePlate = "XYZ123",
            carBrand = "Test Brand",
            vehicleType = "Sedan",
            amountOfPassengers = 4,
            amountOfDoors = 4,
            automatic = true,
            gpsAvailable = true,
            carPriceAmount = 20000.0,
            carPriceCurrency = "EUR",
            userProfileID = 123,
            carLocation = "Test Location"
        )

        viewModel = CarSettingsViewModel(carId = 1)  // Gebruik een specifieke carId
    }

//    @Before
//    fun setup() {
//        Dispatchers.setMain(Dispatchers.Unconfined)
//        coEvery { carRepositoryMock.getCar(any()) } returns Car(
//            id = 1,
//            licencePlate = "44-SB-ZZ",
//            carBrand = "Kia",
//            vehicleType = "C4",
//            amountOfPassengers = 5,
//            amountOfDoors = 5,
//            automatic = false,
//            gpsAvailable = false,
//            carPriceAmount = 12.99,
//            carPriceCurrency = "Euro",
//            userProfileID = 1,
//            carLocation = "Breda"
//        )
//
//        viewModel = CarSettingsViewModel(carId = 1)  // Gebruik een specifieke carId
//    }

    @Test
    fun testUpdateCarBrand(): Unit = runTest {
        val testBrand = "Test Brand"
        viewModel.updateCarBrand(testBrand)
        assertEquals(testBrand, viewModel.carBrand)
    }

    @Test
    fun testGetData(): Unit = runTest {
        val expectedCarBrand = "Kia"
        val expectedLicensePlate = "44-SB-zz"
        val expectedVehicleType = "C4"
        val expectedAmountOfPassengers = 5
        val expectedAmountOfDoors = 5
        val expectedAutomatic = false
        val expectedGpsAvailable = false
        val expectedCarPriceAmount = 12.99
        val expectedCarLocation = "Breda"

        viewModel.getData()
        assertEquals(expectedCarBrand, viewModel.carBrand)
        assertEquals(expectedVehicleType, viewModel.vehicleType)
        assertEquals(expectedLicensePlate, viewModel.licencePlate)
        assertEquals(expectedAmountOfPassengers, viewModel.amountOfPassengers)
        assertEquals(expectedAmountOfDoors, viewModel.amountOfDoors)
        assertEquals(expectedAutomatic, viewModel.gearboxType)
        assertEquals(expectedGpsAvailable, viewModel.gpsAvailable)
        assertEquals(expectedCarPriceAmount, viewModel.carPriceAmount)
        assertEquals(expectedCarLocation, viewModel.carLocation)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}
