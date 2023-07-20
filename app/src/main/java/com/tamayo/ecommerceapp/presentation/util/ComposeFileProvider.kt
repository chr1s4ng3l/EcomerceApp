package com.tamayo.ecommerceapp.presentation.util

import android.content.Context
import android.content.ContextWrapper
import android.graphics.Bitmap
import android.net.Uri
import androidx.core.content.FileProvider
import com.tamayo.ecomerceapp.R
import org.apache.commons.io.FileUtils
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.util.*

/**
 * Custom FileProvider used to provide access to files for other applications.
 * This class extends FileProvider and provides utility methods to work with files and URIs.
 */
class ComposeFileProvider : FileProvider(R.xml.file_paths) {

    companion object {

        /**
         * Creates a temporary file from the given Uri.
         *
         * @param context The context of the application.
         * @param uri The Uri from which the file should be created.
         * @return The created temporary file, or null if an error occurs.
         */
        fun createFileFromUri(context: Context, uri: Uri): File? {
            return try {
                val stream = context.contentResolver.openInputStream(uri)
                val file = File.createTempFile(
                    "${System.currentTimeMillis()}",
                    ".png",
                    context.cacheDir
                )
                FileUtils.copyInputStreamToFile(stream, file)
                return file
            } catch (e: Exception) {
                e.printStackTrace()
                return null
            }
        }

        /**
         * Gets a new image Uri to store images in the application's cache directory.
         *
         * @param context The context of the application.
         * @return The Uri of the newly created image file.
         */
        fun getImageUri(context: Context): Uri {
            val directory = File(context.cacheDir, "images")
            directory.mkdirs()
            val file = File.createTempFile(
                "selected_image_",
                ".jpg",
                directory
            )
            val authority = context.packageName + ".fileprovider"
            return getUriForFile(
                context,
                authority,
                file
            )
        }

        /**
         * Converts a Bitmap into a file and returns the file's path.
         *
         * @param context The context of the application.
         * @param bitmap The Bitmap to be converted to a file.
         * @return The path of the file that contains the converted Bitmap.
         */
        fun getPathFromBitmap(context: Context, bitmap: Bitmap): String {
            val wrapper = ContextWrapper(context)
            var file = wrapper.getDir("Images", Context.MODE_PRIVATE)
            file = File(file, "${UUID.randomUUID()}.jpg")
            val stream: OutputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            stream.flush()
            stream.close()
            return file.path
        }

    }

}
