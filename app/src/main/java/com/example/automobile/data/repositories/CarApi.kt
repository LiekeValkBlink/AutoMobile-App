

import com.example.automobile.data.models.CarLocation
import com.example.automobile.data.models.SaveCarLocationResponse
import com.example.automobile.data.services.CarsApi
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path


interface CarApi {
    suspend fun getCarLocations() : List<CarLocation>

    @Headers("Content-Type: application/json")
    @POST("carlocation/{id}")
    suspend fun savePostal(@Path("id") id: Int, @Body postal: CarLocation) : Response<SaveCarLocationResponse>
}

class NetworkCarLocationRepository(): CarApi{
    override suspend fun getCarLocations(): List<CarLocation> {
        return CarsApi.retrofitService.getCarLocations()
    }

    override suspend fun savePostal(
        id: Int,
        postal: CarLocation
    ): Response<SaveCarLocationResponse> {
        TODO("Not yet implemented")
        return CarsApi.retrofitService.savePostal(id, postal)
    }


}