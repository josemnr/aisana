package com.example.proyecto_moviles

import android.app.Application
import android.os.Bundle
import com.parse.Parse

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Parse.initialize(
            Parse.Configuration.Builder(this).applicationId("3AV4HR9mLK7n1H09OVh3lXXSe0eOLIaVL0Xuxang")
                .clientKey("I15LbIn36Zbzwq0yfgVwYz9rKNQHirBdaAWJQtuT")
                .server("https://parseapi.back4app.com/")
                .build()
        )
    }
}