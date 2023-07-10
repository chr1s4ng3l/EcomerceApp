package com.tamayo.ecommerceapp.domain.util

sealed class ResultState<out T> {
    object Loading : ResultState<Nothing>()
    data class Success<out T>(val data: T) : ResultState<T>()
    data class Failure<out T>(val exception: String) : ResultState<T>()

}
