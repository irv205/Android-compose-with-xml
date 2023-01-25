package com.irv205.composewithxml.domain.service

import com.irv205.composewithxml.domain.model.CharacterDomain
import com.irv205.composewithxml.domain.response.DataResponse

interface NetworkDataSource {
    suspend fun getCharacters(page: Int): DataResponse<List<CharacterDomain>>
}