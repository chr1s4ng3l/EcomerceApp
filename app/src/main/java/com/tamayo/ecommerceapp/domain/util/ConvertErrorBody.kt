package com.tamayo.ecommerceapp.domain.util

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.tamayo.ecommerceapp.domain.model.ErrorResponse
import okhttp3.ResponseBody

object ConvertErrorBody {
    fun convertErrorBody(errorBody: ResponseBody?): ErrorResponse? {
        return try {

            errorBody?.source().let { bufferedSource ->
                val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

                val moshiAdapter = moshi.adapter(ErrorResponse::class.java)
                bufferedSource?.let {
                    moshiAdapter.fromJson(it)
                }
            }

        } catch (e: Exception) {
            Log.d("ErrorBody", "convertErrorBody: ${e.message}")
            null
        }
    }
}