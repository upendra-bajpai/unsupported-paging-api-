package com.cedcos.omdb.network

import com.cedcos.omdb.data.model.MovieModel
import com.cedcos.omdb.data.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Upendra on 19/2/2022.
 */
interface MovieService {

    @GET(".")
    suspend fun getMovies(
    ): List<MovieModel>

}