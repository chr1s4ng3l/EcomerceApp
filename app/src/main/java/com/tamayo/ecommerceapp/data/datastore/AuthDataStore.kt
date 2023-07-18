package com.tamayo.ecommerceapp.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.tamayo.ecommerceapp.core.Config.AUTH_KEY
import com.tamayo.ecommerceapp.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AuthDataStore @Inject constructor(private val dataStore: DataStore<Preferences>) {

    suspend fun saveUser(authResponse: AuthResponse) {
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        dataStore.edit { pref ->

            pref[dataStoreKey] = authResponse.toJson()

        }
    }

    suspend fun delete() {
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        dataStore.edit { pref ->
            pref.remove(dataStoreKey)
        }
    }


    fun getData(): Flow<AuthResponse> {
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)

        return dataStore.data.map { pref ->
            if (pref[dataStoreKey] != null) {
                AuthResponse.fromJson(pref[dataStoreKey]!!)
            } else {
                AuthResponse()
            }
        }
    }
}