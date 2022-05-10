package fr.benchaabane.data.car.remote

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ICarRemoteService {

    @GET("vehicles")
    @Headers("x-api-key: $X_API_KEY")
    suspend fun getCars(): List<CarJson>

    @GET("vehicles/{vehicleId}")
    @Headers("x-api-key: $X_API_KEY")
    suspend fun getCarDetail(@Path("vehicleId") vehicleId: String): CarDetailJson
}

// TODO this should be moved to NDK or to CI Env Variables
private const val X_API_KEY = "aBjYvktsvj7HPGimtDzG9SWbhBos69Y8nPbIELl2"
