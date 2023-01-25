package com.irv205.composewithxml.data.repository

import com.irv205.composewithxml.domain.model.CharacterDomain
import com.irv205.composewithxml.domain.repository.Repository
import com.irv205.composewithxml.domain.response.DataResponse
import com.irv205.composewithxml.domain.service.NetworkDataSource
import javax.inject.Inject

class RepositoryImp @Inject constructor(private val networkDataSource: NetworkDataSource): Repository {

    override suspend fun getCharacters(page: Int): DataResponse<List<CharacterDomain>> {
        return try {
            networkDataSource.getCharacters(page)
        } catch (e: Exception){
            DataResponse.OnFailure(e.message.toString())
        }
    }
}