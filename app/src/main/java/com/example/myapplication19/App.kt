package com.example.myapplication19

import android.app.Application
import com.example.myapplication19.di.AppComponent
import com.example.myapplication19.di.DaggerAppComponent
import com.example.myapplication19.di.modules.DatabaseModule
import com.example.myapplication19.di.modules.DomainModule
import com.example.myapplication19.di.modules.RemoteModule


class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {

        super.onCreate()
        instance = this
        //Создаем компонент
        dagger = DaggerAppComponent.builder()
            .remoteModule(RemoteModule())
            .databaseModule(DatabaseModule())
            .domainModule(DomainModule(this))
            .build()
    }

    companion object {
        lateinit var instance: App
             private set
    }
}
