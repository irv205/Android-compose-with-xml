package com.irv205.composewithxml.data.networkdatasource.service

import com.irv205.composewithxml.data.model.CharacterResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("character")
    suspend fun getCharacters(
        @Query("page") page: Int
    ): CharacterResponseDTO
}