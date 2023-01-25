package com.irv205.composewithxml.data.networkdatasource

import com.irv205.composewithxml.data.mapper.toDomainModel
import com.irv205.composewithxml.data.networkdatasource.service.Service
import com.irv205.composewithxml.domain.model.CharacterDomain
import com.irv205.composewithxml.domain.response.DataResponse
import com.irv205.composewithxml.domain.service.NetworkDataSource
import javax.inject.Inject

class NetworkDataSourceImp @Inject constructor(private val service: Service): NetworkDataSource {

        override suspend fun getCharacters(page: Int): DataResponse<List<CharacterDomain>> {
            val response = service.getCharacters(page)
            return DataResponse.Success(response.toDomainModel())
        }
}