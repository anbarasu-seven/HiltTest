package com.example.android.hilt.data.pref

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

class DataStoreManager(val context: Context) {

    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

    companion object {
        val NAME = stringPreferencesKey("NAME")
        val EMAIL = stringPreferencesKey("EMAIL")
        val PHONE_NUMBER = stringPreferencesKey("PHONE_NUMBER")
    }

    suspend fun save(userData: UserData) {
        context.dataStore.edit {
            it[NAME] = userData.name
            it[EMAIL] = userData.email
            it[PHONE_NUMBER] = userData.phoneNo
        }
    }

    suspend fun getFromDataStore() = context.dataStore.data.map {
        UserData(
            name = it[NAME] ?: "",
            email = it[EMAIL] ?: "",
            phoneNo = it[PHONE_NUMBER] ?: ""
        )
    }

}