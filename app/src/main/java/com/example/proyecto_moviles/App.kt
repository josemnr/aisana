package com.example.proyecto_moviles

import android.app.Application
import com.parse.Parse

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Parse.initialize(
            Parse.Configuration.Builder(this).applicationId(R.string.back4app_app_id.toString())
                .clientKey(R.string.back4app_client_key.toString())
                .server(R.string.back4app_server_url.toString())
                .build()
        )
    }
}