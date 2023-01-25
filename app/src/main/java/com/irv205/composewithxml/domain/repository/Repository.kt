package com.irv205.composewithxml.domain.repository

import com.irv205.composewithxml.domain.model.CharacterDomain
import com.irv205.composewithxml.domain.response.DataResponse

interface Repository {
    suspend fun getCharacters(page: Int): DataResponse<List<CharacterDomain>>
}