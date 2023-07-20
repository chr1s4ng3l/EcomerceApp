package com.tamayo.ecommerceapp.presentation.util

import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import kotlinx.coroutines.delay
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
/**
 * A class that handles activity results and provides utility functions to request different types of activities.
 */
class ResultingActivityHandler {
    private var _callback = mutableStateOf<(@Composable () -> Unit)?>(null)

    /**
     * Request to take a picture in preview mode.
     *
     * @param maxTry The maximum number of tries before giving up on launching the activity.
     * @param millis The delay in milliseconds between each try.
     * @return The captured bitmap if successful, or null if the request was unsuccessful.
     */
    suspend fun takePicturePreview(
        maxTry: Int = 10,
        millis: Long = 200,
    ): Bitmap? {
        return request(
            ActivityResultContracts.TakePicturePreview(),
            maxTry,
            millis
        ) {
            it.launch()
        }
    }

    /**
     * Request to get content with a specific type.
     *
     * @param type The type of content to be retrieved (e.g., image/jpeg, audio/mp3).
     * @param maxTry The maximum number of tries before giving up on launching the activity.
     * @param millis The delay in milliseconds between each try.
     * @return The Uri of the selected content if successful, or null if the request was unsuccessful.
     */
    suspend fun getContent(
        type: String,
        maxTry: Int = 10,
        millis: Long = 200,
    ): Uri? {
        return request(
            ActivityResultContracts.GetContent(),
            maxTry,
            millis
        ) {
            it.launch(type)
        }
    }

    /**
     * Generic function to request an activity result with retry mechanism.
     *
     * @param contract The ActivityResultContract representing the activity to be requested.
     * @param maxTry The maximum number of tries before giving up on launching the activity.
     * @param millis The delay in milliseconds between each try.
     * @param launcher A function that launches the activity result request.
     * @return The result of the activity if successful, or null if the request was unsuccessful.
     */
    suspend fun <I, O> request(
        contract: ActivityResultContract<I, O>,
        maxTry: Int = 10,
        millis: Long = 200,
        launcher: (ManagedActivityResultLauncher<I, O>) -> Unit
    ): O? = suspendCancellableCoroutine { coroutine ->
        _callback.value = {
            val a = rememberLauncherForActivityResult(
                contract
            ) {
                coroutine.resume(it)
                _callback.value = null
                return@rememberLauncherForActivityResult
            }

            LaunchedEffect(a) {
                var tried = 0
                var tryOn = true
                while (tryOn) {
                    ++tried
                    delay(millis)
                    try {
                        launcher(a)
                        tryOn = false
                    } catch (e: Exception) {
                        if (tried > maxTry) {
                            tryOn = false
                            coroutine.resume(null)
                            _callback.value = null
                        }
                    }
                }
            }
        }
    }

    /**
     * Composable function that handles activity results.
     * This function should be called in the composable UI where activity results are expected to be handled.
     */
    @Composable
    fun Handle() {
        if (_callback.value != null) {
            _callback.value?.invoke()
        }
    }
}
