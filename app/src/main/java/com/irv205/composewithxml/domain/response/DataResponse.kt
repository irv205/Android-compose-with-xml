package com.irv205.composewithxml.domain.response

sealed class DataResponse<T> {
    data class Success<T>(val data: T): DataResponse<T>()
    data class OnFailure<T>(val message: String): DataResponse<T>()
}