package com.tamayo.ecommerceapp.domain.util

import com.tamayo.ecommerceapp.domain.model.ErrorResponse
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

object ResponseToRequest {

    fun <T> send(result: Response<T>): ResultState<T> {
        return try {

            if (result.isSuccessful) { // 201
                ResultState.Success(result.body()!!)

            } else {
                val errorResponse: ErrorResponse? =
                    ConvertErrorBody.convertErrorBody(result.errorBody())
                ResultState.Failure(errorResponse?.message ?: "Unexpected error")
            }


        } catch (e: HttpException) {
            e.printStackTrace()
            ResultState.Failure(e.message ?: "Http error request")
        } catch (e: IOException) {
            e.printStackTrace()
            ResultState.Failure("Check your network connection")
        } catch (e: Exception) {
            e.printStackTrace()
            ResultState.Failure(e.message ?: "Unexpected error")
        }
    }

}