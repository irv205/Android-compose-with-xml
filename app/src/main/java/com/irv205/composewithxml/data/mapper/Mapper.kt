package com.irv205.composewithxml.data.mapper

import com.irv205.composewithxml.data.model.CharacterDTO
import com.irv205.composewithxml.data.model.CharacterResponseDTO
import com.irv205.composewithxml.domain.model.CharacterDomain

fun CharacterResponseDTO.toDomainModel(): List<CharacterDomain> {
    return this.result.map { it.toDomain() }
}

fun CharacterDTO.toDomain(): CharacterDomain{
    return CharacterDomain(
        id,
        name,
        status,
        species,
        type,
        gender,
        image)
}