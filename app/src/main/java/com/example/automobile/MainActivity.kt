package com.example.automobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.automobile.app.AutoMobileApp
import com.example.automobile.data.ApiClient
import com.example.automobile.data.repositories.LocalStorageRepository
import java.lang.ref.WeakReference

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * Pass MainActivity to LocalStorageRepository as a WeakReference.
         * This should always be done before any interaction with LocalStorageRepository can occur.
         */
        LocalStorageRepository.context = WeakReference(this)

        setContent {
            AutoMobileApp()
        }
    }
}
